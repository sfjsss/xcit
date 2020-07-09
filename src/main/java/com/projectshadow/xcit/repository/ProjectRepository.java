package com.projectshadow.xcit.repository;

import com.projectshadow.xcit.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
