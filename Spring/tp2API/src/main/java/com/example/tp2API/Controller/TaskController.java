package com.example.tp2API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tp2API.Service.TaskService;

@RestController
public class TaskController {
	
	/*
	 	Objectif: Créer un contrôleur REST pour gérer des tâches avec des opérations CRUD.
		Tâches:
		Créer un service pour gérer les tâches.
		Il doit être possible de créer, lire, mettre à jour et supprimer des tâches.
		Vous n'avez pas besoin de persister les tâches dans une base de données pour le moment.
		Vous viendrez juste stocker les tâches dans une liste en mémoire.
		Les méthodes du contrôleur devront ètre :
			- GET /tasks : retourne la liste des tâches
			- POST /tasks : crée une nouvelle tâche
	 */
	
	@Autowired
	private TaskService task;
	
	// Afficher toutes les tâches
	@GetMapping("/tasks")
	public List<String> getAll() {
		return task.getTasks();
	}
	
	// Création d'une nouvelle tâche
	@PostMapping("/tasks")
	public List<String> postTask(@RequestBody String body) {
		return task.addTask(body);
	}
}
