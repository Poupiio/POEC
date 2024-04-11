import { Component, OnChanges, SimpleChanges } from '@angular/core';
import { ItemService } from '../../Service/item.service';
import { Item } from '../../Model/Item';
import { PanierService } from '../../Service/panier.service';
import { UserService } from '../../Service/user.service';
import { Panier } from '../../Model/Panier';
import { CommonModule } from '@angular/common';
import { ItemComponent } from '../item/item.component';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [CommonModule, ItemComponent],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css'
})
export class CartComponent implements OnChanges {
	constructor(public panier : PanierService, public user : UserService) {
		this.getCart();
	}

	ngOnChanges(changes: SimpleChanges): void {
		this.getCart();
	}


	getCart() {
		this.panier.getPanier(this.user.currentUser?.panier.id!);
	}
}
