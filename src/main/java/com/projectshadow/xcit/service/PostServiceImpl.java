package com.projectshadow.xcit.service;

import com.projectshadow.xcit.entity.Post;
import com.projectshadow.xcit.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }
}
