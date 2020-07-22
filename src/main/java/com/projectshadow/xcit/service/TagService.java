package com.projectshadow.xcit.service;

import com.projectshadow.xcit.entity.Tag;

import java.util.List;

public interface TagService {

    void createTag(Tag newTag);
    List<Tag> findAllTags();
    List<Tag> findAllTagsByCategory(String category);
}
