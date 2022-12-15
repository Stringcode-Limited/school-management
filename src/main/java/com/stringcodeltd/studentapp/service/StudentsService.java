package com.stringcodeltd.studentapp.service;

import com.stringcodeltd.studentapp.dao.StudentRepository;
import com.stringcodeltd.studentapp.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsService {
    @Autowired
    private StudentRepository stdrepo;

    public  Student saveStudent(Student student){
        return stdrepo.save(student);
    }

    public List<Student> getAllStudentDetails(){
     return stdrepo.findAll();
    }

    public Optional<Student> getAllStudentDetailsById(Long studentId){
        Optional<Student> byId = stdrepo.findById(studentId);
        return byId.isPresent() ? Optional.of(byId.get()) : null;
    }

    public String deleteStudent(Long id){
        if(stdrepo.existsById(id)) {
            stdrepo.deleteById(id);
            return "Student with id" + id + " deleted successfully";
        }
        return "There is no student with id "+id;
    }

   public String updateStudent(Long id, Student studentId){
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

    public List<Student> getByDepartment(String dept) {
        return stdrepo.findByDept(dept);
    }

    public List<Student> getByGender(String gender){
        return stdrepo.findByGender(gender);
    }


    public Page<Student> getStudentPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return stdrepo.findAll(pageable);
    }

    public Page<Student> getStudentPagination(Integer pageNumber, Integer pageSize, String sortedProperty) {
        Pageable pageable = null;
        if(null != sortedProperty){
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,sortedProperty);
        }else{
            pageable =  PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,"firstName");
        }

        return stdrepo.findAll(pageable);

    }
}
