package com.stringcodeltd.studentapp.department.controller;

import com.stringcodeltd.studentapp.department.model.Department;
import com.stringcodeltd.studentapp.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @PostMapping()
    public Department createDepartment(@RequestBody Department department){
        return  departmentService.createDepartment(department);
    }

    @GetMapping("/id")
    public List<Department> getDepartmentById(@PathVariable String name){
        return departmentService.getDepartmentByName(name);
    }

}
