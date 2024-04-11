package com.example.mvc.Model.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livre {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	
	private Long id;
	private String titre;
	private String auteur;
	private Integer annee_publication;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public Integer getAnnee_publication() {
		return annee_publication;
	}
	public void setAnnee_publication(Integer annee_publication) {
		this.annee_publication = annee_publication;
	}
	
}
