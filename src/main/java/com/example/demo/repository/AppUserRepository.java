package com.example.demo.repository;

import com.example.demo.model.AppUser;

import java.util.Optional;

public interface AppUserRepository {

    Optional<AppUser> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    AppUser save(AppUser user);
}
