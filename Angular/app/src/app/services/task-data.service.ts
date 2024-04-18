import { Injectable } from '@angular/core';
import { Task, TaskForm, TaskToUpdate } from 'src/types';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TaskDataService {
  tasks: Task[] = [];

  constructor(
    private http: HttpClient
  ) { }

  // Récupérer toutes les tâches d'un projet
  getTasks() : Observable<Task[]> {
    return this.http.get<Task[]>("/tasks").pipe();
  }

  // Récupérer une tâche par son id
  getTaskById(id: number): Task | undefined {
    return this.tasks.find(task => task.id === id);
  }

  // Ajouter une tâche
  async addTask(task: TaskForm) {
    const newTask = await this.http.post<Task>("/tasks", task).toPromise();
    if (!newTask) throw new Error("Task not created");

    this.tasks = [... this.tasks, newTask];
  }

  // Modifier une tâche
  async updateTask(id: number, task: TaskToUpdate) {

    const taskUpdated = await this.http.put<Task>(`/tasks/${id}`, task).toPromise();

    if (!taskUpdated) throw new Error("Task not created");

    // Mise à jour de la liste complète
    this.tasks = [... this.tasks, taskUpdated];
  }

  // Suppression d'une tâche
  async deleteTask(id: number) {
    try {
      await this.http.delete(`/tasks/${id}`).toPromise();
    } catch (error) {
      console.error("Une erreur s'est produite lors de la suppression de la tâche :", error);
      throw error;
    }
  }
}