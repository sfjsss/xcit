package com.projectshadow.xcit.controller;

import com.projectshadow.xcit.entity.Tag;
import com.projectshadow.xcit.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/public/tags")
public class TagController {

    private TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping("")
    public ResponseEntity<Object> createTag(@Valid @RequestBody Tag tag) {
        tag.setId(0);
        tagService.createTag(tag);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Tag>> fetchAllTags() {
        List<Tag> tags = tagService.findAllTags();

        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<Tag>> fetchAllTagsByCategory(@PathVariable String category) {
        List<Tag> tags = tagService.findAllTagsByCategory(category);

        return new ResponseEntity<>(tags, HttpStatus.OK);
    }
}
