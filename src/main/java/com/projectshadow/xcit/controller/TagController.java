package com.projectshadow.xcit.controller;

import com.projectshadow.xcit.entity.Tag;
import com.projectshadow.xcit.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/public/tags")
public class TagController {

    private TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    public ResponseEntity<Object> createTag(@Valid @RequestBody Tag tag) {
        tag.setId(0);
        tagService.createTag(tag);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
