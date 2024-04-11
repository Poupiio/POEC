package com.example.tp4.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tp4.Model.Entity.Entity.Product;
import com.example.tp4.Model.Entity.Repository.ProductRepository;

@Service
public class ProductService {
	public ProductRepository repo;
	
	@Autowired
	public ProductService(ProductRepository dependence) {
		this.repo = dependence;
	}
	
	// Afficher tous les produits
	public List<Product> getAll() {
		return this.repo.findAll();
	}
	
	// Afficher un produit par son id
	public Optional<Product> getById(Long id) {
		return this.repo.findById(id);
	}

	// Ajouter un produit
	public Product add(Product data) {
		return this.repo.save(data);
	}
	
	// Modifier un produit
	public Product update(Long id, Product data) {
		Product product = this.repo.findById(id).get();
		
		product.setName(data.getName());
		product.setPrice(data.getPrice());
		product.setQuantity(data.getQuantity());
		
		return this.repo.save(product);
	}
	
	// Supprimer un produit
	public void delete(Long id) {
		this.repo.deleteById(id);
	}
	
}
