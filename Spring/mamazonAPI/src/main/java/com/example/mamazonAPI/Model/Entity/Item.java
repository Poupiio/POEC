package com.example.mamazonAPI.Model.Entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)

    public Long id;
    public String name;
    public String photo;
    public Double price;
    public Long quantity;
    public String category;

    @ManyToMany(mappedBy = "items")
    private Set<Panier> paniers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Panier> getPaniers() {
        return paniers;
    }

    public void setPaniers(Set<Panier> paniers) {
        this.paniers = paniers;
    }
}
