package com.nese.backend_new.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/**
 * User: Database Entity representing the 'users' table.
 * Maps Java objects to relational database rows using JPA/Hibernate.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key with auto-increment strategy

    @NotBlank(message = "The name cannot be empty.")
    private String name;

    @Min(value = 0, message = "Age cannot be less than 0.")
    @Max(value = 150, message = "Age cannot be greater than 150.")
    private int age;

    // Default constructor required by JPA
    public User() {}

    /**
     * Convenience constructor for creating new User instances.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and Setters
    public Long getId() { return id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}