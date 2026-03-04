package com.nese.backend_new.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository: Data access layer for User entities.
 * Extends JpaRepository to inherit standard CRUD operations (Save, Find, Delete, etc.).
 */
public interface UserRepository extends JpaRepository<User, Long> {
    // Standard methods like save(), findById(), and delete() are automatically implemented
}