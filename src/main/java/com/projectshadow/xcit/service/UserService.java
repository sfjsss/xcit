package com.projectshadow.xcit.service;

import com.projectshadow.xcit.entity.User;

public interface UserService {

    public void save(User user);
    public User findUserByEmail(String email);
}
