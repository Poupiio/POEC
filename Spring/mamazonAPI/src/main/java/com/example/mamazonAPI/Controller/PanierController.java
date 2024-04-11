package com.example.mamazonAPI.Controller;

import com.example.mamazonAPI.Model.Entity.Item;
import com.example.mamazonAPI.Model.Entity.Panier;
import com.example.mamazonAPI.Service.PanierService;
import com.example.mamazonAPI.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/panier")
public class PanierController {
    @Autowired
    private PanierService service;

    @GetMapping
    public List<Panier> getAllPanier() {
        return this.service.getAllPaniers();
    }

    @GetMapping("/{id}")
    public Optional<Panier> getPanierById(@PathVariable Long id) {
        return this.service.getPanierById(id);
    }

    @PostMapping
    public Panier createPanier(@RequestBody Panier body) {
        return this.service.createPanier(body);
    }

    @PutMapping
    public Panier updatePanier(@RequestBody Panier body, @PathVariable Long id) {
        return this.service.updatePanier(id, body);
    }

    @DeleteMapping
    public void deletePanier(@PathVariable Long id) {
        this.service.removePanier(id);
    }
}
