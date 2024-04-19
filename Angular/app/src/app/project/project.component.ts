import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../services/project.service';
import { Router } from '@angular/router';
import { Project, TaskStatus, TaskToDisplay, Task, TaskForm, ProjectForm } from 'src/types';
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

  updateForm: boolean = false;
  addForm: boolean = false;

  // Affichage du formulaire de création de tâche
  showTaskForm: boolean = false;
  title: string = "";
  description: string ="";
  status: TaskStatus = TaskStatus.TO_DO;
  estimation: number = 1;
  projectId: number = 1;
  

  
  constructor(
    private projectService: ProjectService,
    private userService: UserService,
    private taskService: TaskDataService,
    private router: Router
  ) { }


  // PARTIE PROJETS (PENSER A DECOUPER EN 2 COMPOSANTS POUR LES TACHES)
  
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

  // Fermeture de la side bar au clic sur un nom de projet
  closeOffcanvas(): void {
    this.offcanvasVisible = false;
    const offcanvasElement = document.getElementById('myOffCanvas');
    if (offcanvasElement) {
      offcanvasElement.classList.remove('show');
    }
  }

  // Affichage du formulaire d'ajout de projet
  toggleAddForm(): void {
    this.addForm = !this.addForm;
  }

  // Affichage du formulaire de modification de projet
  toggleUpdateForm(): void {
    this.updateForm = !this.updateForm;
  }
  

  // Obtenir l'id du projet cliqué
  getProjectId(projectId: number) {
    console.log("projet id " + projectId);
    this.projectId = projectId;
  }

  // Afficher tous les projets
  async getProjects() {
    this.projectService.getProjects().subscribe(res => {
      this.projects = res;
    });
  }

  async addProject(projectName: string) {
    console.log(projectName);
    
    const newProject: ProjectForm = { 
      name: this.projectName
     };

    try {
      await this.projectService.addProject(newProject);
      await this.getProjects();

      // Je masque le formulaire d'ajout
      this.addForm = false;
      // Je vide le champ du formulaire
      this.projectName = "";
    } catch (error) {
      console.error("Une erreur s'est produite lors de la création du projet.");
    }
  }

  async editProject(projectId: number) {
    console.log("Modification du projet avec l'id " + projectId);

    const projectToUpdate: ProjectForm = {
      name: this.projectName,
    };

    this.projectService.updateProject(projectId, projectToUpdate);
    
  }

  async deleteProject(projectId: number) {
    console.log("Suppression du projet à l'id " + projectId);

    try {
      await this.projectService.deleteProject(projectId);

      // Mise à jour de la liste sans avoir à refresh la page
      this.projects = this.projects.filter(projects => projects.id !== projectId);
      this.getProjects();
    } catch (error) {
      console.error("Une erreur s'est produite lors de la suppression du projet :", error);
    }
  }




   // PARTIE TASKS (PENSER A DECOUPER EN 2 COMPOSANTS POUR LES TACHES)

  // Afficher les tâches d'un projet en fonction de son ID
  getProjectTasks(projectId: number): void {
    this.taskService.getAllTasks(projectId).subscribe(tasks => {
      console.log("Tâches du projet récupérées dans getProjectTasks() : ", tasks);
      
      // Je mets à jour le tableau de tâches pour les récupérer correctement par la suite
      this.tasks = tasks;
      this.displayTasks();
    });
  }

  displayTasks(): void {
    // Pour chaque colonne, je vais filtrer le tableau de tâches (tasks) par leur statut

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

    console.log("Tâches récupérées dans displayTasks() ", this.todo, this.ongoing, this.done);
      
  }

  getTaskDetails(id: number) {
    console.log("Détails d'une tâche");
    
  }

  // Affichage ou disparition du formulaire d'ajout de tâche
  toggleTaskForm(projectId: number) {
    this.projectId = projectId;
    this.showTaskForm = !this.showTaskForm;
  }

  submit() : void {
    const task: TaskForm = {
      title: this.title,
      description: this.description,
      status: this.status,
      estimationHours: this.estimation,
      projectId: this.projectId
    }

    console.log(task.title, task.description, task.status, task.estimationHours, task.projectId);
    
    this.taskService.addTask(task);
    this.toggleTaskForm(this.projectId);
  }

  deleteTask(id: number) {
    console.log("Suppression d'une tâche");
    
  }




  ngOnInit(): void { }
}
