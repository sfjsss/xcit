package com.projectshadow.xcit.repository;

import com.projectshadow.xcit.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findAll();
    List<Tag> findAllByCategoryEquals(String category);
}
