package com.projectshadow.xcit.controller;

import com.projectshadow.xcit.entity.User;
import com.projectshadow.xcit.exception.DuplicateEmailException;
import com.projectshadow.xcit.service.UserService;
import com.projectshadow.xcit.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class UserController {

    private UserService userService;
    private JwtUtil jwtUtil;

    @Autowired
    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/users")
    public ResponseEntity<String> registerUser(@RequestBody User user) {

        User existedUser = userService.findUserByEmail(user.getEmail());
        if (existedUser != null) {
            throw new DuplicateEmailException("This email is duplicated");
        }

        user.setId(0);
        userService.save(user);
        String newToken = jwtUtil.generateToken(user.getEmail());

        return new ResponseEntity<String>(newToken, HttpStatus.CREATED);
    }
}
