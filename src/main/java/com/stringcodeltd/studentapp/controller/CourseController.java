package com.stringcodeltd.studentapp.controller;

import com.stringcodeltd.studentapp.dao.CourseRepository;
import com.stringcodeltd.studentapp.dao.StudentRepository;
import com.stringcodeltd.studentapp.model.Course;
import com.stringcodeltd.studentapp.model.Student;
import com.stringcodeltd.studentapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/course")
public class CourseController{

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentRepository stdRepo;



    @GetMapping()
    public List<Course> getAllCourses(){
        return  courseService.getALlCourses();
    }

    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable("id") int id){
        return courseService.getCourseById(id);
    }

    @GetMapping("/getbycode/{code}")
    public Optional<Course> getCourseByCourseCode(@PathVariable("code") String code){
        return courseService.getCourseByCourseCode(code);
    }

    @GetMapping("/getbydept/{dept}")
    public List<Course> getCourseByDepartment(@PathVariable("dept") String dept){
        return courseService.getCourseByDepartment(dept);
    }

    @GetMapping("/getbydeptandlevel/{dept}/{level}")
    public List<Course> getCourseByDepartmentAndLevel(@PathVariable("dept") String dept, @PathVariable("level") int level){
        return courseService.getCourseByDepartmentAndLevel(dept, level);
    }

    @GetMapping("/getcarryovercourses/{dept}/{level}")
    public List<Course> getForCarryOver(@PathVariable("dept") String dept, @PathVariable("level") int level){
        return courseService.getCarryOverCourses(dept, level);
    }

    @GetMapping("/borrowedCourses/{dept}/{level}")
    public List<Course> getBorrowedCourses(@PathVariable("dept") String dept, @PathVariable("level") int level){
        return courseService.getBorrowedCourses(dept, level);
    }

    @GetMapping("/CarryOverborrowedCourses/{dept}/{level}")
    public List<Course> getCOBorrowedCourses(@PathVariable("dept") String dept, @PathVariable("level") int level){
        return courseService.getCOBorrowedCourses(dept, level);
    }

    @GetMapping("/getbytitle/{title}")
    public Optional<Course> getCourseByTitle(@PathVariable("title") String title){
        return courseService.getCourseByTitle(title);
    }


    @PostMapping()
    public Course addNewCourse(@Valid @RequestBody Course course){
        return courseService.addCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourseById(@Valid @RequestBody Course course, @PathVariable(name = "id") int id){
        return courseService.updateCourseDetailsById(id, course);
    }

    @PutMapping("/updatebycoursecode/{code}")
    public Course updateCourseByCourseCode(@Valid @RequestBody Course course, @PathVariable(name = "code") String code){
        return courseService.updateCourseDetailsByCourseCode(code, course);
    }

    @PutMapping("/addstudent/courseid/{courseId}/studentId/{stdId}")
    public String addStudent(@PathVariable int courseId, @PathVariable Long stdid) {
        return courseService.addStudent(courseId, stdid);
    }

    @DeleteMapping("/{id}")
    public String deleteCourseById(@PathVariable(name = "id") int id){
        return courseService.deleteCourseById(id);
    }

    @DeleteMapping("/deletebycode/{code}")
    public String deleteCourseByCourseCode(@PathVariable(name = "code") String code){
        return courseService.deleteCourseByCourseCode(code);
    }


}
