package com.example.tp5users.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tp5users.Model.Entity.User;
import com.example.tp5users.Model.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	public UserRepository repo;
	
	// Afficher tous les utilisateurs
	public List<User> getAll() {
		return this.repo.findAll();
	}
	
	// Afficher un utilisateur par son id
	public Optional<User> getById(Long id) {
		return this.repo.findById(id);
	}
	
	// Ajouter un utilisateur
	public User add(User data) {
		return this.repo.save(data);
	}
	
	// Modifier un utilisateur
	public User update(Long id, User data) {
		// On va chercher l'id de l'utilisateur
		User user = this.repo.findById(id).get();
		
		// OU
		// Je récupère l'id de l'optional de type User
//		Optional <User> user = this.repo.findById(id);
		// Et je crée un nouvel objet (nouveau user)
//		User u = user.get();
//		u.setName(User.getName());
//		Etc ...
		
		user.setName(data.getName());
		user.setEmail(data.getEmail());
		user.setPassword(data.getPassword());
		user.setRole(data.getRole());
		
		return this.repo.save(user);
	}
	
	// Supprimer un utilisateur
	public String remove(Long id) {
		this.repo.deleteById(id);
		return "L'utilisateur avec l'id " + id + " a bien été supprimé";
	}
	
}
