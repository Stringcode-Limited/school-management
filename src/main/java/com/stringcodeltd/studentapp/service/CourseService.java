package com.stringcodeltd.studentapp.service;

import com.stringcodeltd.studentapp.dao.CourseRepository;
import com.stringcodeltd.studentapp.dao.StudentRepository;
import com.stringcodeltd.studentapp.model.Course;
import com.stringcodeltd.studentapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private StudentRepository stdrepo;

    public Course addCourse(Course course){
        Optional<Course> data = Optional.ofNullable(courseRepo.findByCourseCode(course.getCourseCode()));
        if(data.isPresent()){
            return  null;
        }

        return courseRepo.save(course);
    }

    public String registerStudent(int course_id, Long stdId){
        Optional<Student> studentData = stdrepo.findById(stdId);
        Optional<Course> courseData = courseRepo.findById(course_id);

        if (studentData.isPresent() && courseData.isPresent()) {
            Student newstudent = studentData.get();
            Course newcourse = courseData.get();

            newcourse.getStudent().add(newstudent);
            courseRepo.save(newcourse);
            return "Student added successfully";

        } else {
            return "Student or Course not found";
        }
    }

    public List<Course> getALlCourses(){
        return courseRepo.findAll();
    }

    public Optional<Course> getCourseById(int courseId){
        Optional<Course> course = courseRepo.findById(courseId);
        return course.isPresent() ? course : null;
    }

    public Optional<Course> getCourseByCourseCode(String code){
        Optional<Course> course = Optional.ofNullable(courseRepo.findByCourseCode(code));
        return course.isPresent() ? course : null;
    }


    public Course updateCourseDetailsById(int id, Course course){
        Optional<Course> data = Optional.ofNullable(courseRepo.findByCourseCode(course.getCourseCode()));

        if(courseRepo.existsById(id)){
            Course newCourse = courseRepo.findById(id).get();
            String oldcode = newCourse.getCourseCode();

            newCourse.setCourseCode(course.getCourseCode());
            newCourse.setDepartment(course.getDepartment());
            newCourse.setCourseTitle(course.getCourseTitle());
            newCourse.setCourseLevel(course.getCourseLevel());

            if(!data.isPresent() || newCourse.getCourseCode().equalsIgnoreCase(oldcode)){
                courseRepo.save(newCourse);
                return  newCourse;
            }


        }

        return  null;
    }

    public Course updateCourseDetailsByCourseCode(String code, Course course){
        Optional<Course> data = Optional.ofNullable(courseRepo.findByCourseCode(code));
        Optional<Course> coursecode = Optional.ofNullable(courseRepo.findByCourseCode(course.getCourseCode()));
        if(data.isPresent()){
            Course newCourse = courseRepo.findByCourseCode(code);

            String oldcode = newCourse.getCourseCode();

            newCourse.setCourseCode(course.getCourseCode());
            newCourse.setDepartment(course.getDepartment());
            newCourse.setCourseTitle(course.getCourseTitle());
            newCourse.setCourseLevel(course.getCourseLevel());

            if(!coursecode.isPresent() || newCourse.getCourseCode().equalsIgnoreCase(oldcode)){
                courseRepo.save(newCourse);
                return  newCourse;
            }


        }

        return  null;
    }
    public String deleteCourseById(int id){
        if(courseRepo.existsById(id)){
            courseRepo.deleteById(id);

            return id + "has been deleted suessfully";
        }

        return id + "does not exist";
    }

    public String deleteCourseByCourseCode(String code){
        Optional<Course> course = Optional.ofNullable(courseRepo.findByCourseCode(code));
        if(course.isPresent()){
            courseRepo.delete(course.get());

            return code + "has been deleted suessfully";
        }

        return code + "does not exist";
    }

    public Optional<Course> getCourseByTitle(String courseTitle){
        Optional<Course> course = Optional.ofNullable(courseRepo.findByCourseTitle(courseTitle));
        return  course.isPresent() ? course : null;
    }


}
