package com.stringcodeltd.studentapp.controller;

import com.stringcodeltd.studentapp.address.controller.AddressController;
import com.stringcodeltd.studentapp.address.dao.AddressRepository;
import com.stringcodeltd.studentapp.address.service.AddressService;
import com.stringcodeltd.studentapp.model.Student;
import com.stringcodeltd.studentapp.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/vi/students")
public class StudentController {

    @Autowired
//    private StudentRepository stdrepo;
    private StudentsService studentsService;
    @Autowired
    private AddressService addressService;

    @GetMapping()
    public List<Student> getallStudent(){return studentsService.getAllStudentDetails();
    }
//get student by matruc nomber

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable(name="id") Long stdid){return studentsService.getAllStudentDetailsById(stdid);

    }

   @PostMapping()
   public Student createStudent(@Valid @RequestBody Student student){
        return studentsService.saveStudent(student);

   }

   @DeleteMapping("/{id}")
   public String deleteStudent(@PathVariable(name="id") Long id){ return studentsService.deleteStudent(id);
   }

   @PutMapping("/{id}")
   public String  updateStudent(@PathVariable(name="id")Long id, @Valid @RequestBody Student studentId){ return  studentsService.updateStudent(id,studentId);

    }

@GetMapping("/filterbydept/{department}")
    public List<Student> getByDepartment(@PathVariable(name="department") String dept){ return studentsService.getByDepartment(dept);
}

@GetMapping("/filterbygender/{gender}")
    public List<Student> getByGender(@PathVariable(name="gender") String gender){ return studentsService.getByGender(gender);
}

}
