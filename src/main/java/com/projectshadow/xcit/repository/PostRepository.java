package com.projectshadow.xcit.repository;

import com.projectshadow.xcit.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
