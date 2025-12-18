package com.example.demo.service;

import com.example.demo.model.AppUser;
import com.example.demo.repository.AppUserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    private final AppUserRepository repository;

    public AuthService(AppUserRepository repository) {
        this.repository = repository;
    }

    public List<AppUser> getAll() {
        return repository.findAll();
    }

    public Optional<AppUser> getById(Long id) {
        return repository.findById(id);
    }

    public AppUser save(AppUser user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
