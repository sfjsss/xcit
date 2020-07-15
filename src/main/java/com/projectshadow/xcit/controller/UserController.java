package com.projectshadow.xcit.controller;

import com.projectshadow.xcit.entity.User;
import com.projectshadow.xcit.exception.UserNotFoundException;
import com.projectshadow.xcit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.findUserByEmail(email);

        if (user == null) {
            throw new UserNotFoundException("a user associated with this email cannot be found");
        }

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
