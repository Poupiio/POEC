package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Entity.Utilisateur;
import com.example.demo.Model.Repository.UtilisateurRepository;

// ctr + shift + o pour generer les imports

@Service // bean
public class UtilisateurService {
	private UtilisateurRepository userR;
	
	
	// Constructeur
	@Autowired
	public UtilisateurService(UtilisateurRepository userRepo)
	{
		this.userR = userRepo;
	}
	
	Utilisateur saveUser(Utilisateur user)
	{
		return userR.save(user);
	}

}
