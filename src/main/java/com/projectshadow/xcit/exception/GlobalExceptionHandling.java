package com.projectshadow.xcit.exception;

import com.projectshadow.xcit.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {

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

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException unfe) {

        Map<String, String> messages = new HashMap<>();
        messages.put("invalidEmail", unfe.getMessage());

        ErrorResponse uer = new ErrorResponse(404, messages);

        return new ResponseEntity<>(uer, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        System.out.println(ex.getBindingResult().toString());

        return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }
}
