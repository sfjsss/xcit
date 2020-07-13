package com.projectshadow.xcit.repository;

import com.projectshadow.xcit.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAll();
}
