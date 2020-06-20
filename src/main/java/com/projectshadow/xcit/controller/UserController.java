package com.projectshadow.xcit.controller;

import com.projectshadow.xcit.entity.User;
import com.projectshadow.xcit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User registerUser(@RequestBody User user) {

        User existedUser = userService.findUserByEmail(user.getEmail());

        user.setId(0);
        userService.save(user);

        return user;
    }
}
