package com.rikkei.session9.custom_validator;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
            super( message);
    }
}
