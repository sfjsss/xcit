package com.projectshadow.xcit.service;

import com.projectshadow.xcit.entity.Project;
import com.projectshadow.xcit.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void save(Project project) {
        projectRepository.save(project);
    }
}
