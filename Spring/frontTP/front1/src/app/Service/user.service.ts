import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { UserDTO } from '../Model/UserDTO';
import { LogsDTO } from '../Model/logsDTO';
import { Item } from '../Model/Item';
import { User } from '../Model/User';
import { PanierService } from './panier.service';
import { Panier } from '../Model/Panier';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http : HttpClient) { }

  serviceURL = 'http://localhost:3000/users';

  connected : boolean = false;
  currentUser : User | null = null;

  getPanier(id : number) {
	this.http.get<Panier>("http://localhost:3000/paniers" + '/' + id).subscribe(
	  (data) => {
		if (this.currentUser) {
		  this.currentUser.panier = data;
		}
	  }
	);
	  }

  // update user
  updateUser(user: User) : Observable<User> {
	return this.http.put<User>(this.serviceURL + '/' + user.id, user);
  }

  convertUserToUserDTO(user : User) : UserDTO {
	let userDTO : UserDTO = {
	  id : user.id,
	  name : user.name,
	  email : user.email,
	  password : user.password,
	  age : user.age,
	  panier : user.panier.id
	};
	return userDTO;
  }

  // Connect user
  connectUser(user : LogsDTO)  {
	this.http.post<UserDTO>(this.serviceURL + '/login', user).subscribe(
	  (data) => {
		this.currentUser = {
		  id : data.id!,
		  name : data.name!,
		  email : data.email!,
		  password : data.password!,
		  age : data.age!,
		  panier : {id : data.panier!} as Panier
		};
		this.connected = true;
		this.getPanier(data.panier!);
	  }
	);
  }
  inscription(user : LogsDTO) {
	this.http.post<User>(this.serviceURL + '/register', user).subscribe(
	  (data) => {
		console.log(data);
	  }
	);
  }


  // Disconnect user
  disconnectUser() {
	this.currentUser = null;
	this.connected = false;
  }

}
