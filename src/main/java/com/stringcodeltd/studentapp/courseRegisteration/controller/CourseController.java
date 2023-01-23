package com.stringcodeltd.studentapp.courseRegisteration.controller;

import com.stringcodeltd.studentapp.courseRegisteration.dao.CourseRepository;
import com.stringcodeltd.studentapp.courseRegisteration.model.Course;
import com.stringcodeltd.studentapp.courseRegisteration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/course")
public class CourseController{

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private CourseService courseService;


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

    @DeleteMapping("/{id}")
    public String deleteCourseById(@PathVariable(name = "id") int id){
        return courseService.deleteCourseById(id);
    }

    @DeleteMapping("/deletebycode/{code}")
    public String deleteCourseByCourseCode(@PathVariable(name = "code") String code){
        return courseService.deleteCourseByCourseCode(code);
    }


}
