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
  getProjects(): Observable<Project[]> {
    return this.http.get<Project[]>("/project").pipe();
  }

}
