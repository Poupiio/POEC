package com.example.mamazonAPI.Service;

import com.example.mamazonAPI.Model.Entity.Item;
import com.example.mamazonAPI.Model.Entity.Panier;
import com.example.mamazonAPI.Model.Repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PanierService {
    @Autowired
    private PanierRepository repo;

    public List<Panier> getAllPaniers() {
        return this.repo.findAll();
    }

    public Optional<Panier> getPanierById(Long id) {
        return this.repo.findById(id);
    }

    public Panier createPanier(Panier data) {
        return this.repo.save(data);
    }

    public Panier updatePanier(Long id, Panier data) {
        Panier panier = this.repo.findById(id).get();

        return this.createPanier(panier);
    }

    public void removePanier(Long id) {
        this.repo.deleteById(id);
    }
}
