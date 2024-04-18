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

  // Utilisation de ActivatedRoute pour récupérer l'id de la tâche via les paramètres de l'URL
  constructor(
    private router: Router,
    private taskDataService: TaskDataService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
  }

  async submit(): Promise<void> {

    // Récupération de l'id de la tâche via les paramètres url
    this.route.params.subscribe(params => {
      const taskId = params['id'];

      // Création d'un objet de type TaskToUpdate pour envoyer les données au serveur
      const taskToUpdate: TaskToUpdate = {
        title: this.title,
        description: this.description,
        status: this.status,
        estimationHours: this.estimation
      };

      this.taskDataService.updateTask(taskId, taskToUpdate);

      // Redirection vers la page du tableau Kanban
      this.router.navigate(['/dragdrop']);
    });
    
  }
}
