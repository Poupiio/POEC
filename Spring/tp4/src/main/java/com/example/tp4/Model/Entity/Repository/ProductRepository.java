package com.example.tp4.Model.Entity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tp4.Model.Entity.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
