package com.example.mvc.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.Model.Entity.Utilisateur;
import com.example.mvc.Model.Repository.UtilisateurRepository;

@Service
public class UtilisateurService {
	private UtilisateurRepository userR;
		
	@Autowired
	public UtilisateurService(UtilisateurRepository userRepo) {
		this.userR = userRepo;
	}
	
	Utilisateur saveUser(Utilisateur user) {
		return userR.save(user);
	}
}