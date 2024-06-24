package com.demo.web_services.Resources.Exceptions;

import com.demo.web_services.Exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(
            ResourceNotFoundException exception,
            HttpServletRequest request) {
        String error ="Resource not found.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),
                status.value(), error, exception.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

}
