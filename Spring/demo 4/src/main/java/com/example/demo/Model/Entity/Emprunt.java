package com.example.demo.Model.Entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.example.demo.Model.Utilisateur;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "livre_id")
    private Livre livre;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    private LocalDate dateEmprunt;
    private LocalDate dateRetour;

    public Emprunt() {
    }

    public Emprunt(Livre livre, Utilisateur utilisateur, LocalDate dateEmprunt, LocalDate dateRetour) {
        this.livre = livre;
        this.utilisateur = utilisateur;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }
}
