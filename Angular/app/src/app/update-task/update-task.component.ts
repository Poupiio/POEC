import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TaskDataService } from '../services/task-data.service';
import { TaskForm, TaskStatus, TaskToUpdate } from 'src/types';

@Component({
  selector: 'app-update-task',
  templateUrl: "./update-task.component.html",
  styleUrls: [ "./update-task.component.scss"
  ]
})
export class UpdateTaskComponent implements OnInit {
  title: string = "";
  description: string = "";
  status: TaskStatus = TaskStatus.TODO;
  estimation: number = 1;
  taskId: number = 1;

  constructor(
    private router: Router,
    private taskDataService: TaskDataService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
  }

  async submit(): Promise<void> {

    // Récupérer l'ID de la tâche de la route actuelle
    this.route.params.subscribe(params => {
      const taskId = params['id'];
      console.log("id récupéré : " + taskId);


      const taskToUpdate: TaskToUpdate = {
        title: this.title,
        description: this.description,
        status: this.status,
        estimationHours: this.estimation
      };

      console.log("Données à modifier : " + this.title, this.description, this.status, this.estimation);
    
      this.taskDataService.updateTask(taskId, taskToUpdate);
      this.router.navigate(['/dragdrop']);
    });
    
  }
}
