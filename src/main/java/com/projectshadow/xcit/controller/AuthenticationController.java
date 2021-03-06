package com.projectshadow.xcit.controller;

import com.projectshadow.xcit.entity.User;
import com.projectshadow.xcit.exception.DuplicateEmailException;
import com.projectshadow.xcit.exception.InvalidCredentialException;
import com.projectshadow.xcit.service.UserService;
import com.projectshadow.xcit.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/public/authentication")
public class AuthenticationController {

    private UserService userService;
    private JwtUtil jwtUtil;

    @Autowired
    public AuthenticationController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {

        User existedUser = userService.findUserByEmail(user.getEmail());
        if (existedUser != null) {
            throw new DuplicateEmailException("This email is duplicated");
        }

        user.setId(0);
        userService.save(user);
        String newToken = jwtUtil.generateToken(user.getEmail());

        return new ResponseEntity<String>(newToken, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        if (!userService.authenticateUser(user.getEmail(), user.getPassword())) {
            throw new InvalidCredentialException("the input credential is invalid");
        }

        String newToken = jwtUtil.generateToken(user.getEmail());

        return new ResponseEntity<String>(newToken, HttpStatus.OK);
    }
}
