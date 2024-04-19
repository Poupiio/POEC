import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserToGet, UserId, User } from 'src/types';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users: UserToGet[] = [];

  constructor(
    private http: HttpClient
  ) { }

  // Récupérer toutes les tâches d'un projet
  getUsers() : Observable<UserToGet[]> {
    return this.http.get<UserToGet[]>("/user").pipe();
  }

  getUserById(id: number): Observable<UserToGet> {
    return this.http.get<UserToGet>(`/user/${id}`).pipe(
      tap(user => {
        console.log('ID de l\'utilisateur récupéré :', user.id);
      })
    );
  }
}
