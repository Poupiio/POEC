package com.example.mamazonAPI.Controller;

import com.example.mamazonAPI.Model.DTO.UserDTO;
import com.example.mamazonAPI.Model.Entity.User;
import com.example.mamazonAPI.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    /*
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return this.service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id) {
        return this.service.getUserById(id);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO body) {
        return this.service.createUser(body);
    }

    @PutMapping
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO body) {
        return this.service.updateUser(id, body);
    }

    @DeleteMapping
    public void deleteUser(@PathVariable Long id) {
        this.service.deleteUser(id);
    }

     */



    @GetMapping
    public List<User> getAllUsers() {
        return this.service.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return this.service.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User body) {
        return this.service.createUser(body);
    }

    @PutMapping
    public User updateUser(@RequestBody User body, @PathVariable Long id) {
        return this.service.updateUser(id, body);
    }

    @DeleteMapping
    public void removeUser(@PathVariable Long id) {
        this.service.removeUser(id);
    }

}
