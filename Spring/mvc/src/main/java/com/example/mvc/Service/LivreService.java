package com.example.mvc.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.Model.Entity.Livre;
import com.example.mvc.Model.Repository.LivreRepository;

@Service
public class LivreService {
	private LivreRepository livreRepository;
	
	// Constructeur appelant le bean "LivreRepository"
	@Autowired
	public LivreService(LivreRepository livreRepository) {
		this.livreRepository = livreRepository;
	}
	
	// Sauvegarder
	Livre saveLivre(Livre livre) {
		return livreRepository.save(livre);
	}

	// Récupérer tous les livres
	Iterable<Livre> getAllLivres(){
		return livreRepository.findAll();
	}
	
	// Retrouver un livre par son id
	Optional<Livre> findById(Long id) {
		return livreRepository.findById(id);
	}
	
	// Vérifier si un livre existe grâce à son id
	boolean existsById(Long id) {
		if (livreRepository.existsById(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	// Supprimer un livre par son id
	void deleteById(Long id) {
		livreRepository.deleteById(id);
	}
	
	// Supprimer tous les livres gérés par LireRepository
	void deleteAll() {
		livreRepository.deleteAll();
	}

	// Compter le nombre de livres existants
	Long count(Livre livre) {
		return livreRepository.count();
	}
}
