package com.nese.backend_new.user;

import com.nese.backend_new.exception.NotFoundException;
import com.nese.backend_new.user.dto.UserResponse;
import com.nese.backend_new.user.dto.UserUpsertRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService: Contains business logic for User management.
 * Orchestrates data between DTOs and the Database Entity.
 */
@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    /**
     * Converts a request DTO to an entity and persists it.
     */
    public UserResponse create(UserUpsertRequest req) {
        User u = new User(req.getName(), req.getAge());
        User saved = repo.save(u);
        return toResponse(saved);
    }

    /**
     * Retrieves all users and maps them to a list of response DTOs.
     */
    public List<UserResponse> list() {
        return repo.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    /**
     * Fetches a single user or throws NotFoundException if not present.
     */
    public UserResponse get(Long id) {
        User u = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found: " + id));
        return toResponse(u);
    }

    /**
     * Updates an existing user's details and saves the changes.
     */
    public UserResponse update(Long id, UserUpsertRequest req) {
        User u = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found: " + id));

        u.setName(req.getName());
        u.setAge(req.getAge());

        User saved = repo.save(u);
        return toResponse(saved);
    }

    /**
     * Checks for existence before attempting to delete.
     */
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("User not found: " + id);
        }
        repo.deleteById(id);
    }

    /**
     * Internal helper to map an Entity to a Response DTO.
     */
    private UserResponse toResponse(User u) {
        return new UserResponse(u.getId(), u.getName(), u.getAge());
    }
}