package com.projectshadow.xcit.exception;

import com.projectshadow.xcit.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleDuplicateEmailException(DuplicateEmailException dex) {

        Map<String, String> messages = new HashMap<>();
        messages.put("email", dex.getMessage());

        ErrorResponse uer = new ErrorResponse(409, messages);

        return new ResponseEntity<>(uer, HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleInvalidCredentialException(InvalidCredentialException ice) {

        Map<String, String> messages = new HashMap<>();
        messages.put("invalidCredential", ice.getMessage());

        ErrorResponse uer = new ErrorResponse(401, messages);

        return new ResponseEntity<>(uer, HttpStatus.UNAUTHORIZED);
    }
}
