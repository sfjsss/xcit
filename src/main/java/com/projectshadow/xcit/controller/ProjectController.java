package com.projectshadow.xcit.controller;

import com.projectshadow.xcit.entity.Project;
import com.projectshadow.xcit.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/public/projects")
public class ProjectController {

    private ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("")
    public ResponseEntity<Object> createProject(@Valid @RequestBody Project project) {
        project.setId(0);
        projectService.save(project);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Project>> fetchAllProjects() {
        System.out.println("get mapping for fetch all projects has been reached");
        List<Project> projects = projectService.getAllProjects();

        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
}
