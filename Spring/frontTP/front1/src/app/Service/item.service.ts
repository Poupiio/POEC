import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Item } from '../Model/Item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  constructor(public http : HttpClient) { }

  serviceURL = 'http://localhost:3000/items';
  // crud operations

  // get all items
  getItems() : Observable<Item[]> {
	return this.http.get<Item[]>(this.serviceURL);
  }

  // get item by id
  getItemById(id : number): Observable<Item> {
	return this.http.get<Item>(this.serviceURL + '/' + id);
  }

  // add item
  addItem(item : Item) : Observable<Item> {
	return this.http.post<Item>(this.serviceURL, item);
  }

  // update item
  updateItem(item : Item) : Observable<Item>  {
	return this.http.put<Item>(this.serviceURL + '/' + item.id, item);
  }

  // delete item

  deleteItem(id : number) {
	return this.http.delete(this.serviceURL + '/' + id);
  }
}
