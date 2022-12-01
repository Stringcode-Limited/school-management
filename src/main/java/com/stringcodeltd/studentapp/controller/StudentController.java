package com.stringcodeltd.studentapp.controller;

import com.stringcodeltd.studentapp.dao.AddressRepository;
import com.stringcodeltd.studentapp.dao.StudentRepository;
import com.stringcodeltd.studentapp.model.Address;
import com.stringcodeltd.studentapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/vi/students")
public class StudentController {

    @Autowired
    private StudentRepository stdrepo;

    @Autowired
    private AddressRepository addressrepo;

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
   public Student createStudent(@Valid @RequestBody Student student){
        return stdrepo.save(student);
   }

   @DeleteMapping("/{id}")
   public String deleteStudent(@PathVariable(name="id") Long id){
        if(stdrepo.existsById(id)) {
            stdrepo.deleteById(id);
            return "Student with id" + id + " deleted successfully";
        }
        return "There is no student with id "+id;

   }

   @PutMapping("/{id}")
   public String  updateStudent(@PathVariable(name="id")Long id, @Valid @RequestBody Student studentId){

        if(stdrepo.existsById(id)){
            Student std =  stdrepo.findById(id).get();
            std.setFirstName(studentId.getFirstName());
            std.setLastName(studentId.getLastName());
            std.setDepartment(studentId.getDepartment());
            std.setGender(studentId.getGender());
            std.setLevel(studentId.getLevel());

            stdrepo.save(std);
            return "Record updated successfully";
        }
        return "No student with such an id";
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
