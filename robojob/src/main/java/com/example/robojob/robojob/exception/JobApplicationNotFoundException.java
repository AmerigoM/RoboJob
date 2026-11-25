package com.example.robojob.robojob.exception;

public class JobApplicationNotFoundException extends RuntimeException {
    public JobApplicationNotFoundException(Long id) {
        super("Product not found with id " + id);
    }
}
