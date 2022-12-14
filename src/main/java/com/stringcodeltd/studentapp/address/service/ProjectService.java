package com.stringcodeltd.studentapp.address.service;

import com.stringcodeltd.studentapp.dao.ProjectRepository;
import com.stringcodeltd.studentapp.project.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    public Project createNewProject(Project project) {
        return projectRepository.save(project);
    }
}
