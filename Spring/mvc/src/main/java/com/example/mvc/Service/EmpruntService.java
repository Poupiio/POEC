package com.example.mvc.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.Model.Entity.Emprunt;
import com.example.mvc.Model.Entity.Livre;
import com.example.mvc.Model.Repository.EmpruntRepository;

@Service
public class EmpruntService {
	private EmpruntRepository empruntRepo;
	
	@Autowired
	public EmpruntService(EmpruntRepository empruntRepo) {
		this.empruntRepo = empruntRepo;
	}
	
	// Sauvegarder un emprunt
	Emprunt saveEmprunt(Emprunt emprunt) {
		return empruntRepo.save(emprunt);
	}
	
	// Récupérer tous les emprunts
	Iterable<Emprunt> getAllEmprunts(){
		return empruntRepo.findAll();
	}
	
	// Supprimer un emprunt par son id
	void deleteById(Long id) {
		empruntRepo.findById(id);
	}
	
	// Supprimer tous les emprunts
	void deleteAll() {
		empruntRepo.deleteAll();
	}
	
	// Trouver un emprunt par son id
	Optional<Emprunt> findById(Long id) {
		return empruntRepo.findById(id);
	}
	
	// Compter le nombre de livres existants
	Long count(Emprunt emprunt) {
		return empruntRepo.count();
	}
}
