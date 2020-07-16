package com.projectshadow.xcit.service;

import com.projectshadow.xcit.entity.User;

import java.util.List;

public interface UserService {

    public void save(User user);
    public User findUserByEmail(String email);
    public List<User> findAllUserWithEmailExcept(String email);
    public boolean authenticateUser(String email, String password);
}
