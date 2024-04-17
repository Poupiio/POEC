import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from 'src/types';

type LoginResponse = {
  accessToken: string
} | string;

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  accessToken: string | null = null;

  constructor(
    private http: HttpClient
  ) { }

  async login(email: string, password: string) : Promise<User | string> {
    try {
      const res = await this.http.post<LoginResponse>("/login", {
        email,
        password
      }).toPromise();
  
      if (typeof res === "string" || !res)
        throw new Error(res);

      const payload = res.accessToken.split(".")[1];
      const decoded = atob(payload);
      const user = JSON.parse(decoded) as User;
      
      this.accessToken = res.accessToken;

      localStorage.setItem("token", this.accessToken);
      
      return user;
      
    } catch (e: any) {
      if (e instanceof HttpErrorResponse) {
        return e.error;
      } else {
        return "OH NO! An error has occured :(";
      }
    }
  }
}
