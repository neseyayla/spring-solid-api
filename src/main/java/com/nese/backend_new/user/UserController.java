package com.nese.backend_new.user;

import com.nese.backend_new.user.dto.UserResponse;
import com.nese.backend_new.user.dto.UserUpsertRequest;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * UserController: Exposes REST API endpoints for User management.
 * Handles HTTP requests and coordinates with the UserService.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    // Constructor injection for better testability and dependency management
    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * Creates a new user. 
     * @Valid ensures the UserUpsertRequest meets defined constraints.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@Valid @RequestBody UserUpsertRequest req) {
        return service.create(req);
    }

    /**
     * Retrieves all users as a list of DTOs.
     */
    @GetMapping
    public List<UserResponse> list() {
        return service.list();
    }

    /**
     * Retrieves a specific user by their unique ID.
     */
    @GetMapping("/{id}")
    public UserResponse get(@PathVariable Long id) {
        return service.get(id);
    }

    /**
     * Updates an existing user's information.
     */
    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id, @Valid @RequestBody UserUpsertRequest req) {
        return service.update(id, req);
    }

    /**
     * Deletes a user and returns a confirmation message.
     */
    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        service.delete(id);
        return Map.of("deleted", true, "id", id);
    }
}