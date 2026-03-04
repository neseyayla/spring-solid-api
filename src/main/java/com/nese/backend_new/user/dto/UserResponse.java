package com.nese.backend_new.user.dto;

/**
 * UserResponse: Data Transfer Object (DTO) for sending user data to the client.
 * Decouples the internal Database Entity from the external API response.
 */
public class UserResponse {
    private Long id;
    private String name;
    private int age;

    /**
     * Constructor to initialize the response data.
     */
    public UserResponse(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Standard Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
}