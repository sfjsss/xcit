package com.projectshadow.xcit.service;

import com.projectshadow.xcit.entity.User;
import com.projectshadow.xcit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
