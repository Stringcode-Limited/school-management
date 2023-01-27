package com.stringcodeltd.studentapp.controller;

import com.stringcodeltd.studentapp.dao.CourseRepository;
import com.stringcodeltd.studentapp.dao.StudentRepository;
import com.stringcodeltd.studentapp.model.Course;
import com.stringcodeltd.studentapp.service.CourseService;
import com.stringcodeltd.studentapp.service.AddressService;
import com.stringcodeltd.studentapp.model.Student;
import com.stringcodeltd.studentapp.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/vi/students")
public class StudentController {

    @Autowired
//    private StudentRepository stdrepo;
    private StudentsService studentsService;

    @Autowired
    private StudentRepository stdRepo;

    @Autowired
    private AddressService addressService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepo;

    @GetMapping()
    public List<Student> getallStudent(){return studentsService.getAllStudentDetails();
    }
//get student by matruc nomber

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable(name="id") Long stdid){return studentsService.getAllStudentDetailsById(stdid);
    }

    @GetMapping("/studentsWithoutAnyCourses")
    public List<Student> getStudentsWithoutAnyCourses() {
        return studentsService.getStudentsWithoutAnyCourses();
    }

    @GetMapping("/studentsNotOfferingaCourse/{code}")
    public List<Student> studentsNotOfferingaCourse(@PathVariable String code) {
        return studentsService.getStudentsNotOfferingaCourse(code);
    }


    @GetMapping("/getcourses/{id}")
    public Set<Course> getStudentCourses(@PathVariable("id") Long id) {
        return studentsService.getStudentCourses(id);
    }

   @PostMapping()
   public Student createStudent(@Valid @RequestBody Student student){
        return studentsService.saveStudent(student);

   }


    @PutMapping("/addcourse/studentid/{studid}/courseid/{courseId}")
    public String addCourse(@PathVariable Long studid, @PathVariable int courseId) {
        return studentsService.registerCourse(studid, courseId);
    }

    @PutMapping("/addcoursebycode/studentid/{studid}/courseid/{courseCode}")
    public String addCourseByCode(@PathVariable Long studid, @PathVariable String courseCode) {
        return studentsService.registerCourseByCourseCode(studid, courseCode);
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

@GetMapping("/pagination/{pageNumber}/{pageSize}")
    public Page<Student> studentPage(@PathVariable Integer pageNumber, @PathVariable Integer pageSize){
        return studentsService.getStudentPagination(pageNumber,pageSize);
}

@GetMapping("/pagination/{pageNumber}/{pageSize}/{sortedProperty}")
    public Page<Student> studentPageffj(@PathVariable Integer pageNumber,
                                           @PathVariable Integer pageSize,
                                           @PathVariable String sortedProperty){
        return studentsService.getStudentPagination(pageNumber, pageSize, sortedProperty);
}



}
