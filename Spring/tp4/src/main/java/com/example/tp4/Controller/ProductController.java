package com.example.tp4.Controller;

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

import com.example.tp4.Model.Entity.Entity.Product;
import com.example.tp4.Service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public Iterable<Product> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Product> getById(@PathVariable("id") Long id) {
		return this.service.getById(id);
	}
	
	@PostMapping
	public Product add(@RequestBody Product body) {
		return this.service.add(body);
	}
	
	@PutMapping("/{id}")
	public Product update(@RequestBody Product body, @PathVariable("id") Long id) {
		return this.service.update(id, body);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
}
