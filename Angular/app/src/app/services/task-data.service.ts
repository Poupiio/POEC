import { Injectable } from '@angular/core';
import { Task, TaskForm, TaskStatus } from 'src/types';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TaskDataService {
  tasks: Task[] = [];

  constructor(
    private http: HttpClient
  ) { }

  getTasks() : Task[] {
    return this.tasks;
  }

  getTaskById(id: number): Task | undefined {
    return this.tasks.find(task => task.id === id);
  }

  async addTask(task: TaskForm) {
    const newTask = await this.http.post<Task>("/tasks", task).toPromise();
    if (!newTask) throw new Error("Task not created");

    this.tasks = [... this.tasks, newTask];
  }
}