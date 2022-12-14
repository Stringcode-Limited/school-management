package com.stringcodeltd.studentapp.controller;

import com.stringcodeltd.studentapp.address.service.ProjectService;
import com.stringcodeltd.studentapp.project.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/project")
public class ProjectController {

    @Autowired
   private  ProjectService projectService;

    @GetMapping()
    public List<Project> getallproject(){
        return projectService.getAllProject();
    }
    @PostMapping()
    public Project createnewproject(@Valid  @RequestBody Project project){
        return projectService.createNewProject(project);
    }
}
