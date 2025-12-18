package com.example.demo.controller;

import com.example.demo.model.AppUser;
import com.example.demo.service.AuthService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @GetMapping
    public List<AppUser> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AppUser getById(@PathVariable Long id) {
        return service.getById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostMapping
    public AppUser create(@RequestBody AppUser user) {
        return service.save(user);
    }

    @PutMapping("/{id}")
    public AppUser update(@PathVariable Long id, @RequestBody AppUser user) {
        AppUser existing = service.getById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existing.setUsername(user.getUsername());
        existing.setPassword(user.getPassword());
        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
