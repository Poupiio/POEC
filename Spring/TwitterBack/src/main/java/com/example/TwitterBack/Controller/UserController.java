package com.example.TwitterBack.Controller;

import com.example.TwitterBack.Model.Entity.User;
import com.example.TwitterBack.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost/3050")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public List<User> getAllUsers() {
        return this.service.getAllUsers();
    }

    @GetMapping("/name/{username}")
    public Optional<User> findByUsername(@PathVariable String username) {
        return service.findByUsername(username);
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return this.service.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User data) {
        return this.service.createUser(data);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User body, @PathVariable Long id) {
        return this.service.updateUser(id, body);
    }

    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable Long id) {
        return this.service.removeUser(id);
    }

    // Connexion
    @PostMapping("/login")
    public User connection(@RequestBody User data) throws Exception {
        try {
            return this.service.findUser(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
