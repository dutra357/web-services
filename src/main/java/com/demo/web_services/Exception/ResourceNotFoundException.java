package com.demo.web_services.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Object id) {
        super("Resource not found: " + id);
    }
}
