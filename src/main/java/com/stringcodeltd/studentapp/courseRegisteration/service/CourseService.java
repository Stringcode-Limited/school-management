package com.stringcodeltd.studentapp.courseRegisteration.service;

import com.stringcodeltd.studentapp.courseRegisteration.dao.CourseRepository;
import com.stringcodeltd.studentapp.courseRegisteration.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepo;

    public Course addCourse(Course course){
        Optional<Course> data = Optional.ofNullable(courseRepo.findByCourseCode(course.getCourseCode()));
        if(data.isPresent()){
            return  null;
        }

        return courseRepo.save(course);
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
            newCourse.setCourseDepartment(course.getCourseDepartment());
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
            newCourse.setCourseDepartment(course.getCourseDepartment());
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
            courseRepo.deleteByCourseCode(code);

            return code + "has been deleted suessfully";
        }

        return code + "does not exist";
    }

    public Optional<Course> getCourseByTitle(String courseTitle){
        Optional<Course> course = Optional.ofNullable(courseRepo.findByCourseTitle(courseTitle));
        return  course.isPresent() ? course : null;
    }


}
