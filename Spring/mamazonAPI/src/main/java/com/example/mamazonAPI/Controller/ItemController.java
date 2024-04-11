package com.example.mamazonAPI.Controller;

import com.example.mamazonAPI.Model.Entity.Item;
import com.example.mamazonAPI.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService service;

    @GetMapping
    public List<Item> getAllItems() {
        return this.service.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable Long id) {
        return this.service.getItemById(id);
    }

    @PostMapping
    public Item createItem(@RequestBody Item body) {
        return this.service.createItem(body);
    }

    @PutMapping
    public Item updateItem(@RequestBody Item body, @PathVariable Long id) {
        return this.service.updateItem(id, body);
    }

    @DeleteMapping
    public void deleteItem(@PathVariable Long id) {
        this.service.removeItem(id);
    }
}
