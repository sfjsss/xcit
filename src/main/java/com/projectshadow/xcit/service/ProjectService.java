package com.projectshadow.xcit.service;

import com.projectshadow.xcit.entity.Project;

import java.util.List;

public interface ProjectService {

    void save(Project project);
    List<Project> getAllProjects();
}
