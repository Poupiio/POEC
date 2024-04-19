import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Project, ProjectForm, UserToGet } from 'src/types';
import { UserService } from './user.service';
import { Observable, switchMap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  projects: Project[] = [];
  user: UserToGet | undefined;

  constructor(private http: HttpClient,
    private userService: UserService
  ) { }


  // TEST SANS AVOIR DE USER

  // Afficher tous les projets de la BDD
  getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>("/project").pipe();
  }

  // Ajouter un projet
  async addProject(project: ProjectForm) {
    const newProject = await this.http.post<Project>("/project", project).toPromise();
    if (!newProject) throw new Error("Project not created");

    // this.projects = [... this.projects, newProject];

     // Rafraîchir la liste des projets depuis le serveur
    this.getProjects().subscribe(projects => {
      this.projects = projects;
    });
  }

  // Modification d'un projet
  async updateProject(id: number, project: ProjectForm) {

    const updatedProject = await this.http.put<Project>(`/project/${id}`, project).toPromise();

    if (!updatedProject) throw new Error("Task not created");

    // Mise à jour de la liste complète
    this.projects = [... this.projects, updatedProject];
  }



  // Suppression d'un projet
  async deleteProject(id: number) {
    try {
      await this.http.delete(`/project/${id}`).toPromise();
    } catch (error) {
      console.error("Une erreur s'est produite lors de la suppression du projet :", error);
      throw error;
    }
  }
}
