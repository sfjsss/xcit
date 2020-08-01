package com.projectshadow.xcit.controller;

import com.projectshadow.xcit.entity.Post;
import com.projectshadow.xcit.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/public/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("")
    public ResponseEntity<Object> createPost(@Valid @RequestBody Post post) {
        post.setId(0);
        postService.save(post);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
