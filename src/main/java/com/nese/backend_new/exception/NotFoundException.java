package com.nese.backend_new.exception;

/**
 * NotFoundException: A custom unchecked exception used when a requested 
 * resource (e.g., User, Portfolio) does not exist in the database.
 */
public class NotFoundException extends RuntimeException {
    
    /**
     * Constructs the exception with a specific error message.
     * @param message The detail message explaining which resource was not found.
     */
    public NotFoundException(String message) {
        super(message);
    }
}