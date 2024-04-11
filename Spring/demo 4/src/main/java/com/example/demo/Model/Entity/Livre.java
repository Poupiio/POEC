package com.example.demo.Model.Entity;

import org.springframework.data.annotation.Id;

import com.example.demo.Model.myliste;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private myliste<Object> maliste;

    private String titre;
    private String auteur;
    private Integer anneePublication;

    public Livre() {
    }

    public Livre(String titre, String auteur, Integer anneePublication) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
    }
}
