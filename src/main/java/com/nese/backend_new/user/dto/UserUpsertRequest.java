package com.nese.backend_new.user.dto;

import jakarta.validation.constraints.*;

/**
 * UserUpsertRequest: DTO for capturing and validating user input 
 * during Create (POST) or Update (PUT) operations.
 */
public class UserUpsertRequest {

    @NotBlank(message = "Name cannot be empty.")
    private String name;

    @Min(value = 0, message = "Age cannot be less than zero.")
    @Max(value = 150, message = "Age cannot be greater than 150.")
    private int age;

    // Default constructor for JSON deserialization
    public UserUpsertRequest() {}

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}