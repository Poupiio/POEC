package com.example.tp5users.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tp5users.Model.Entity.User;
import com.example.tp5users.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping
	public List<User> getAll() {
		return this.service.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<User> getById(@PathVariable Long id) {
		return this.service.getById(id);
	}
	
	@PostMapping
	public User add(@RequestBody User body) {
		return this.service.add(body);
	}
	
	@PutMapping("/{id}")
	public User update(@RequestBody User body, @PathVariable Long id) {
		return this.service.update(id, body);
	}
	
	@DeleteMapping
	public void remove(@PathVariable Long id) {
		this.service.remove(id);
	}
}
