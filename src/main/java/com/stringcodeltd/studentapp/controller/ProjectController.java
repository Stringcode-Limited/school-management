package com.stringcodeltd.studentapp.controller;

import com.stringcodeltd.studentapp.address.service.ProjectService;
import com.stringcodeltd.studentapp.project.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public Optional<Project> getProjectById(@PathVariable(value = "id") Long projectId){
        return projectService.getProjectById(projectId);
    }

    @PutMapping("/{id}")
    public Optional<Project> updateProject(@PathVariable(value = "id")   Long id, @RequestBody Project project){
        return projectService.updateProject(id, project);
    }
    @DeleteMapping


}
