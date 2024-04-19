import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../services/project.service';
import { Router } from '@angular/router';
import { Project, TaskStatus, TaskToDisplay, Task } from 'src/types';
import { UserService } from '../services/user.service';
import { TaskDataService } from '../services/task-data.service';

@Component({
  selector: 'app-project',
  templateUrl: "./project.component.html",
  styleUrls: [ "./project.component.scss"
  ]
})
export class ProjectComponent implements OnInit {
  projectName: string = "";
  offcanvasVisible: boolean = false;
  projects: Project[] = [];

  tasks: Task[] = [];
  todo: TaskToDisplay[] = [];
  ongoing: TaskToDisplay[] = [];
  done: TaskToDisplay[] = [];

  
  constructor(
    private projectService: ProjectService,
    private userService: UserService,
    private taskService: TaskDataService,
    private router: Router
  ) { }
  
  // Gestion de l'affichage de la side bar
  toggleOffcanvas(): void {
    this.offcanvasVisible = !this.offcanvasVisible;
    const offcanvasElement = document.getElementById('myOffCanvas');
    if (this.offcanvasVisible) {
      offcanvasElement?.classList.add('show');
    } else {
      offcanvasElement?.classList.remove('show');
    }
  }

  // Fermer la side bar au clic sur un nom de projet
  closeOffcanvas(): void {
    this.offcanvasVisible = false;
    const offcanvasElement = document.getElementById('myOffCanvas');
    if (offcanvasElement) {
      offcanvasElement.classList.remove('show');
    }
  }

  addProject(name: string) {
    console.log("coucou");
    
  }

  ngOnInit(): void { }

  async getProjects() {
    this.projectService.getProjects().subscribe(res => {
      this.projects = res;
    });
  }

  // Afficher les tâches d'un projet en fonction de son ID
  getProjectTasks(projectId: number): void {
    console.log("projet id " + projectId);
    
    this.taskService.getAllTasks(projectId).subscribe(tasks => {
      console.log(tasks);
      
      this.displayTasks();
    });
  }

  displayTasks(): void {
    // COLONNE A FAIRE
    this.todo = this.tasks
      .filter(task => task.status === TaskStatus.TO_DO)
      .map(task => ({ title: task.title, id: task.id  }));

    // COLONNE EN COURS
    this.ongoing = this.tasks
      .filter(task => task.status === TaskStatus.ONGOING)
      .map(task => ({ title: task.title, id: task.id }));

    // COLONNE TERMINÉ
    this.done = this.tasks
      .filter(task => task.status === TaskStatus.DONE)
      .map(task => ({ title: task.title, id: task.id }));

      console.log(this.todo, this.ongoing, this.done);
      
  }

  getTaskDetails(id: number) {
    console.log("Détails d'une tâche");
    
  }

  redirectUpdateForm(id: number) {
    console.log("Modification de tâche");
    
  }

  deleteTask(id: number) {
    console.log("Suppression d'une tâche");
    
  }
}
