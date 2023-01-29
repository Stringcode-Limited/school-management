package com.stringcodeltd.studentapp.department.controller;

import com.stringcodeltd.studentapp.department.model.Department;
import com.stringcodeltd.studentapp.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/filterbydeptname/{name}")
    public List<Department> getDepartmentById(@PathVariable(name="name") String name){
        return departmentService.getDepartmentByName(name);
    }
//update department names

    @PutMapping("/{id}")
    public String updateDepartment(@PathVariable(name="id") Long id, @Valid @RequestBody Department department){
     return departmentService.updateDepartment(department,id);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable(name="id")Long id){
        return departmentService.deleteDepartment(id);
    }
}
