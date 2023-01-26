package com.stringcodeltd.studentapp.department.controller;

import com.stringcodeltd.studentapp.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping()
    public List<Long> getAllDepartment(){
        return departmentService.getAllDepartment();
    }
}
