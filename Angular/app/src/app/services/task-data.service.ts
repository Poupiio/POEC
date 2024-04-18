import { Injectable } from '@angular/core';
import { Task, TaskForm, TaskStatus } from 'src/types';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { AuthService } from '../auth.service';

@Injectable({
  providedIn: 'root'
})
export class TaskDataService {
  tasks: Task[] = [];

  constructor(
    private http: HttpClient,
    private auth: AuthService
  ) { }

  getTasks() : Observable<Task[]> {
    return this.http.get<Task[]>("/tasks").pipe();
  }

  getTaskById(id: number): Task | undefined {
    return this.tasks.find(task => task.id === id);
  }

  async addTask(task: TaskForm) {
    const newTask = await this.http.post<Task>("/tasks", task).toPromise();
    if (!newTask) throw new Error("Task not created");

    this.tasks = [... this.tasks, newTask];
  }

  async deleteTask(id: number) {
    console.log("côté service : " + id);
    
    try {
      console.log("ID de la tâche à supprimer :", id);
          
      await this.http.delete(`/tasks/${id}`).toPromise();
    } catch (error) {
      console.error("Une erreur s'est produite lors de la suppression de la tâche :", error);
      throw error;
    }
  }
}