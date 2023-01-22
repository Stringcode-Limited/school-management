package com.stringcodeltd.studentapp.controller;

import com.stringcodeltd.studentapp.model.Teacher;
import com.stringcodeltd.studentapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/vi/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("all")
    public List<Teacher> getallTeacher(){return teacherService.getAllTeachersDetails();}
    @GetMapping("/{id}")
    public Optional<Teacher> getTeacherById(@PathVariable(name="id")Long teacherId) {
        return teacherService.getAllTeacherDetailsById(teacherId);
    }
    @PostMapping()
    public Teacher addTeacher(@Valid @RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable(name="id") Long id){
        return teacherService.deleteTeacher(id);
    }
}
