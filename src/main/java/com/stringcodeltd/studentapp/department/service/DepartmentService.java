package com.stringcodeltd.studentapp.department.service;

import com.stringcodeltd.studentapp.department.dao.DepartmentRepository;
import com.stringcodeltd.studentapp.department.model.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;


    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department createDepartment(Department department) {

        if(departmentRepository.existsByDepartmentName(department.getDepartmentName())){
            throw new RuntimeException("Department is already exists");
        }
        return departmentRepository.save(department);
    }

    public List<Department> getDepartmentByName(String departmentName) {
      return departmentRepository.findByDepartmentName(departmentName);
    }

    public String updateDepartment(Department depart, Long id) {
        if(departmentRepository.existsById(id)){
            Department department = departmentRepository.findById(id).get();
            department.setDepartmentName(depart.getDepartmentName());
            departmentRepository.save(department);
            return "Department with and id "+id+" updated successfully";

;        }
        return "Sorry we update failed because no department with such and Id";
    }

}
