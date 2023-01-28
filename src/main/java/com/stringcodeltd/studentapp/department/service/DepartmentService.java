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
        return departmentRepository.save(department);
    }
}
