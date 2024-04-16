import { Component, OnInit } from '@angular/core';
import { TaskStatus, Task, TaskForm } from "../../types";
import { Router } from '@angular/router';
import { TaskDataService } from '../services/task-data.service';

@Component({
  selector: 'app-task',
  templateUrl: "./task.component.html",
  styleUrls: [ "./task.component.scss"
  ]
})
export class TaskComponent implements OnInit {
  title: string = "";
  description: string ="";
  status: TaskStatus = TaskStatus.TODO;
  estimation: number = 1;
  projectId: number = 1;
  
  constructor(
    private router: Router,
    private taskDataService: TaskDataService
  ) { }

  submit() : void {
    console.log(this.title, this.description, this.status, this.estimation, this.projectId);

    // Partial indique qu'un champ peut potentiellement être vide
    const task: Partial<TaskForm> = {
      title: this.title,
      description: this.description,
      status: this.status,
      estimationHours: this.estimation,
      projectId: this.projectId
    }

    this.taskDataService.addTask(task);
  
    this.router.navigate(['/dragdrop']);
  }

  ngOnInit(): void {}

}
