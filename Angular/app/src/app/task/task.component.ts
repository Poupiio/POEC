import { Component, OnInit } from '@angular/core';
import { TaskStatus, Task, TaskForm } from "../../types";
import { ActivatedRoute, Router } from '@angular/router';
// import { TaskDataService } from '../services/task-data.service';
import { TaskService } from '../services/task.service';
import { ProjectService } from '../services/project.service';

@Component({
  selector: 'app-task',
  templateUrl: "./task.component.html",
  styleUrls: [ "./task.component.scss"
  ]
})
export class TaskComponent implements OnInit {
  title: string = "";
  description: string ="";
  status: TaskStatus = TaskStatus.TO_DO;
  estimation: number = 1;
  projectId: number = 1;
  
  constructor(
    private router: Router,
    private taskService: TaskService,
    private projectService: ProjectService,
    private route: ActivatedRoute
  ) { }

  submit() : void {
    const newTask: TaskForm = {
      title: this.title,
      description: this.description,
      status: this.status,
      estimationHours: this.estimation,
      projectId: this.projectId
    }

    this.taskService.addTask(this.projectId, newTask);
  
    this.router.navigate(['/project']);
    this.taskService.getAllTasks(this.projectId);
  }

  ngOnInit(): void {
    // Récupération de l'id du projet depuis l'URL
    this.route.queryParams.subscribe(params => {
      this.projectId = params['projectId'];
      console.log('ID du projet:', this.projectId);
    });
  }

}
