package com.projectshadow.xcit.controller;

import com.projectshadow.xcit.entity.Project;
import com.projectshadow.xcit.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/public/project")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    public ResponseEntity<Object> createProject(@Valid @RequestBody Project project) {
        project.setId(0);
        projectService.save(project);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
