package com.example.ExempleAPIBDD.Controller;

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

import com.example.ExempleAPIBDD.Model.Entity.UserEntity;
import com.example.ExempleAPIBDD.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	
	// ROUTE CRUD
	@GetMapping
	public Iterable<UserEntity> getAll()
	{
		return this.service.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<UserEntity> getById(@PathVariable Long id)
	{
		return this.service.getById(id);
	}
	
	@PostMapping
	public UserEntity postEntity(@RequestBody UserEntity data)
	{
		return this.service.AddUser(data);
	}

	@PutMapping("/{id}")
	public UserEntity putEntity(@RequestBody UserEntity data, @PathVariable Long id)
	{
		return this.service.UpdateById(id, data);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEntity(@PathVariable Long id)
	{
		this.service.DeleteById(id);
	}
}
