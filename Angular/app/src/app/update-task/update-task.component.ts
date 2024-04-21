import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
// import { TaskDataService } from '../services/task-data.service';
import { TaskService } from '../services/task.service';
import { TaskForm, TaskStatus, Task } from 'src/types';

@Component({
  selector: 'app-update-task',
  templateUrl: "./update-task.component.html",
  styleUrls: [ "./update-task.component.scss"
  ]
})
export class UpdateTaskComponent implements OnInit {
  title: string = "";
  description: string = "";
  status: TaskStatus = TaskStatus.TO_DO;
  estimation: number = 1;
  taskId: number = 1;

  tasks: Task[] = [];

  // Utilisation de ActivatedRoute pour récupérer l'id de la tâche via les paramètres de l'URL
  constructor(
    private router: Router,
    private taskService: TaskService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
  }

  getProjectTasks(projectId: number) {
    this.taskService.getAllTasks(projectId).subscribe(res => {
      this.tasks = res;
    });
  }

  async submit(): Promise<void> {

    // Récupération de l'id de la tâche via les paramètres url
    this.route.params.subscribe(params => {
      const taskId = params['taskId'];
      const projectId = params['projectId'];

      console.log("id de la tâche " + taskId + " et id du projet " + projectId);
      
      // Création d'un objet de type TaskToUpdate pour envoyer les données au serveur
      const updatedTask: TaskForm = {
        title: this.title,
        description: this.description,
        status: this.status,
        estimationHours: this.estimation,
        projectId: projectId
      };

      this.taskService.updateTask(projectId, taskId, updatedTask);

      // Redirection vers la page du tableau Kanban
      // this.router.navigate(["/project"]);

       // Mise à jour des tâches après avoir ajouté une nouvelle tâche
       this.getProjectTasks(projectId);
      
       // Redirection vers la page du projet avec l'ID du projet
       this.router.navigate(['/project'], { queryParams: { projectId: projectId } });
    });
    
  }
}
