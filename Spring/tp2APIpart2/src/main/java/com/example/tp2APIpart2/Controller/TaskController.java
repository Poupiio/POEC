package com.example.tp2APIpart2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tp2APIpart2.Service.TaskService;

/*
 	Objectif: Créer un contrôleur REST pour gérer des tâches avec des opérations CRUD.
	Tâches:
	Créer un service pour gérer les tâches.
	Il doit être possible de créer, lire, mettre à jour et supprimer des tâches.
	Vous n'avez pas besoin de persister les tâches dans une base de données pour le moment.
	Vous viendrez juste stocker les tâches dans une liste en mémoire.
	Les méthodes du contrôleur devront ètre :
		- GET /tasks : retourne la liste des tâches
		- GET /tasks/{id} : retourne une tâche par son id
		- POST /tasks : crée une nouvelle tâche
		- PUT /tasks/{id} : met à jour une tâche
		- DELETE /tasks/{id} : supprime une tâche
 */

@RestController
public class TaskController {
	@Autowired
	private TaskService task;
	
	// Afficher toutes les tâches
	@GetMapping("/tasks")
	public List<String> getAll() {
		return task.getTasks();
	}
	
	// Afficher une tâche par son id
	@GetMapping("/tasks/{id}")
	public String getTask(@PathVariable Integer id) {
		return task.getTask(id);
	}
	
	// Création d'une nouvelle tâche
	@PostMapping("/tasks")
	public List<String> postTask(@RequestBody String body) {
		return task.addTask(body);
	}
	
	// Modification d'une tâche par son id
	@PutMapping("/tasks/{id}")
	public String addTask(@RequestBody String body, @PathVariable Integer id) {
		return task.updateTask(id, body);
	}
	
	// Suppression d'une tâche par son id
	@DeleteMapping("/tasks/{id}")
	public String removeTask(@PathVariable Integer id) {
		return task.deleteTask((int) id);
	}
}
