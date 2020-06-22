package com.projectshadow.xcit.exception;

import com.projectshadow.xcit.model.UserErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleDuplicateEmailException(DuplicateEmailException dex) {

        Map<String, String> messages = new HashMap<>();
        messages.put("email", "this email has already existed");

        UserErrorResponse uer = new UserErrorResponse(409, messages);

        return new ResponseEntity<>(uer, HttpStatus.CONFLICT);
    }
}
