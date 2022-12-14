package com.stringcodeltd.studentapp.address.service;

import com.stringcodeltd.studentapp.dao.ProjectRepository;
import com.stringcodeltd.studentapp.model.Student;
import com.stringcodeltd.studentapp.project.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Project> getProjectById(Long projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        if(project.isPresent()){
            return project;
        }else
            return null;
    }

    public Optional<Project> updateProject( Long id,Project project) {
//        Optional<Project> projectid = projectRepository.findById(id);

            if(projectRepository.existsById(id)){
                Project prj =  projectRepository.findById(id).get();
                prj.setProjecctName(project.getProjecctName());

                Project save = projectRepository.save(prj);
                return Optional.of(save);
        }else
            return null;
    }
}
