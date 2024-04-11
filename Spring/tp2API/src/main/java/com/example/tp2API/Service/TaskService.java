package com.example.tp2API.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TaskService {

	// Initialisation d'une liste de tâches vide
	private List<String> tasks = new ArrayList<String>();
	
	// Afficher toutes les tâches
	public List<String> getTasks() {
		return this.tasks;
	}
	
	// Création d'une nouvelle tâche
	public List<String> addTask(String newTask) {
		// Ajout à la liste "tasks"
		this.tasks.add(newTask);
		
		return this.tasks;
	}
	
	
}
