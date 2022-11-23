package com.stringcodeltd.studentapp.controller;

import com.stringcodeltd.studentapp.dao.StudentRepository;
import com.stringcodeltd.studentapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

   @PostMapping()
   public Student createStudent(@RequestBody Student student){
        return stdrepo.save(student);
   }

   @DeleteMapping("/{id}")
   public String deleteStudent(@PathVariable(name="id") Long id){
        stdrepo.deleteById(id);
        return "Student with "+id +" deleted successfully";

   }

@GetMapping("/filterbydept/{department}")
    public List<Student> getByDepartment(@PathVariable(name="department") String dept){
        return stdrepo.findByDept(dept);
}

@GetMapping("/filterbygender/{gender}")
    public List<Student> getByGender(@PathVariable(name="gender") String gender){
        return stdrepo.findByGender(gender);
}

}
