package com.projectshadow.xcit.service;

import com.projectshadow.xcit.entity.Tag;
import com.projectshadow.xcit.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public void createTag(Tag newTag) {
        tagRepository.save(newTag);
    }

    @Override
    public List<Tag> findAllTags() {
        return tagRepository.findAll();
    }
}
