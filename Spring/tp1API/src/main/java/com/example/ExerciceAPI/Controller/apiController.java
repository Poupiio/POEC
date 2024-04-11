package com.example.ExerciceAPI.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class apiController {
	
	/* Objectif: Créer un contrôleur REST simple pour gérer des requêtes HTTP.
	    Tâches: Développer un contrôleur REST avec une route GET retournant un message simple.
    */
	
	@GetMapping("/exo")
	public String getMessage() {
		return "Je suis un message simple";
	}
}
