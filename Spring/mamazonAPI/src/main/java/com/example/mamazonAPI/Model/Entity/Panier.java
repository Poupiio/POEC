package com.example.mamazonAPI.Model.Entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)

    public Long id;

    @ManyToMany
    @JoinTable(name="panier_items",
            joinColumns = @JoinColumn(name="panier_id"),
            inverseJoinColumns = @JoinColumn(name="item_id")
    )
    public Set<Item> items = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Set<Item> getListItems() {
        return items;
    }

    public void setListItems(Set<Item> listItems) {
        this.items = listItems;
    }

}
