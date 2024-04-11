package com.example.mamazonAPI.Service;

import com.example.mamazonAPI.Model.Entity.Item;
import com.example.mamazonAPI.Model.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repo;

    public List<Item> getAllItems() {
        return this.repo.findAll();
    }

    public Optional<Item> getItemById(Long id) {
        return this.repo.findById(id);
    }

    public Item createItem(Item data) {
        return this.repo.save(data);
    }

    public Item updateItem(Long id, Item data) {
        Item item = this.repo.findById(id).get();


        return this.createItem(item);
    }

    public void removeItem(Long id) {
        this.repo.deleteById(id);
    }
}
