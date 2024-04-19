import { Component, OnInit } from '@angular/core';
import { ProjectService } from '../services/project.service';
import { Router } from '@angular/router';
import { Project } from 'src/types';
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

  
  constructor(
    private projectService: ProjectService,
    private userService: UserService,
    private taskService: TaskDataService,
    private router: Router
  ) { }
  
  toggleOffcanvas(): void {
    this.offcanvasVisible = !this.offcanvasVisible;
    const offcanvasElement = document.getElementById('myOffCanvas');
    if (this.offcanvasVisible) {
      offcanvasElement?.classList.add('show');
    } else {
      offcanvasElement?.classList.remove('show');
    }
  }

  addProject(name: string) {
    console.log("coucou");
    
  }

  ngOnInit(): void {
    this.projectService.getProjects().subscribe(res => {
      this.projects = res;
    });
  }

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
    });
  }

  // async displayTasks() {

  // }

  // getProjectsByCurrentUser() {
  //   // Récupérez l'utilisateur actuellement connecté
  //   this.userService.getCurrentUser().subscribe((user: UserToGet) => {
  //     // Utilisez l'ID de l'utilisateur pour récupérer ses projets
  //     this.projectService.getUserProjects(user.id).subscribe(projects => {
  //       this.projects = projects;
  //     });
  //   });
  // }

}
