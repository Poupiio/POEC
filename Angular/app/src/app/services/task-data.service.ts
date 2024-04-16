import { Injectable } from '@angular/core';
import { Task, TaskForm, TaskStatus } from 'src/types';

@Injectable({
  providedIn: 'root'
})
export class TaskDataService {
  tasks: Task[] = [];

  getTasks() : Task[] {
    return this.tasks;
  }

  getTaskById(id: number): Task | undefined {
    return this.tasks.find(task => task.id === id);
  }

  addTask(task: Partial<TaskForm>) : void {
    const newTask: Task = {
      id: this.tasks.reduce((max, task) => task.id > max ? task.id : max, 0) + 1,
      title: task.title as string,
      description: task.description,
      status: task.status as TaskStatus,
      estimationHours: task.estimationHours as number,
      projectId: task.projectId as number
    }

    this.tasks = [... this.tasks, newTask];
  }

  // setTasks(title: string) : void {
  //   this.titles = [...this.titles, ...title];
  // }

  constructor(
  ) { }
}
