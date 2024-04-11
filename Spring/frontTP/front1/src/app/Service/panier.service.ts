import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { Panier } from '../Model/Panier';
import { Item } from '../Model/Item';

@Injectable({
  providedIn: 'root'
})
export class PanierService {

  constructor(public http : HttpClient, public user : UserService) { }

  serviceURL = 'http://localhost:3000/paniers';

  addPanier(item : Item) {
	this.http.post<Panier>(this.serviceURL + '/' + this.user.currentUser?.panier.id, item).subscribe(
	  (data) => {
		if (this.user.currentUser) {
		  this.user.currentUser.panier = data;
		}
	  }
	);
  }

  getPanier(id : number) {
	this.http.get<Panier>(this.serviceURL + '/' + id).subscribe(
	  (data) => {
		if (this.user.currentUser) {
		  this.user.currentUser.panier = data;
		}
	  }
	);
	}

	findPanier(id : number) {
		return this.http.get<Panier>(this.serviceURL + '/items/' + id)
	}


  removePanier(item : Item) {
	this.http.post<Panier>(this.serviceURL + '/remove' + this.user.currentUser?.panier.id, item).subscribe(
	  (data) => {
		if (this.user.currentUser) {
		  this.user.currentUser.panier = data;
		}
	}
	);
  }
}
