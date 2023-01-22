package com.stringcodeltd.studentapp.service;

import com.stringcodeltd.studentapp.dao.TeacherRepository;
import com.stringcodeltd.studentapp.model.Student;
import com.stringcodeltd.studentapp.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TeacherService {

    @Autowired
   private TeacherRepository teacherRepository;
    public Teacher saveTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public List<Teacher> getAllTeachersDetails(){return teacherRepository.findAll();}

    public Optional<Teacher> getAllTeacherDetailsById(Long teacherId){
        Optional<Teacher> byId = teacherRepository.findById(teacherId);
        return byId.isPresent() ? Optional.of(byId.get()) : null;
    }

    public String deleteTeacher(Long id){

        if(teacherRepository.existsById(id)){
            teacherRepository.deleteById(id);
            return "Teacher with id" + id + " deleted successfully";

        }
        return "There is no teacher with id "+id;

    }


}
