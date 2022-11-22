package com.stringcodeltd.studentapp.controller;

import com.stringcodeltd.studentapp.dao.StudentRepository;
import com.stringcodeltd.studentapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/vi/students")
public class StudentController {

    @Autowired
    private StudentRepository stdrepo;

    @GetMapping()
    public List<Student> getallStudent(){
        return stdrepo.findAll();
    }
//get student by matruc nomber

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable(name="id") Long stdid){
        Optional<Student> byId = stdrepo.findById(stdid);

        return byId.isPresent() ? Optional.of(byId.get()) : null;

    }
}
