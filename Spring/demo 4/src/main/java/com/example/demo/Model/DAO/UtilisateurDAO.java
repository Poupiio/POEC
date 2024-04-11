package com.example.demo.Model;

import java.util.List;

public interface UtilisateurDAO {
	Utilisateur findById(Long id);
	List<Utilisateur> findAll();
	void save(Utilisateur user);
	void update(Utilisateur user);
	void delete(Utilisateur user);
}
