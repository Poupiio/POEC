package com.example.tp2APIpart2.Service;

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
	
	// Afficher une tâche par son id
	public String getTask(Integer index) {
		return this.tasks.get((int) index);
	}

	// Création d'une nouvelle tâche
	public List<String> addTask(String newTask) {
		// Ajout à la liste "tasks"
		this.tasks.add(newTask);
		return this.tasks;
	}
	
	// Modifier une tâche
	public String updateTask(Integer index, String data) {
		this.tasks.set(index, data);
		
		return data;
	}
	
	// Supprimer une tâche par son id
	public String deleteTask(Integer index) {
		this.tasks.remove((int) index);
		return "";
	}
}
