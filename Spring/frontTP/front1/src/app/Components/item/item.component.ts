import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';
import { ItemService } from '../../Service/item.service';
import { UserService } from '../../Service/user.service';
import { Item } from '../../Model/Item';
import { PanierService } from '../../Service/panier.service';

@Component({
  selector: 'app-item',
  standalone: true,
  imports: [],
  templateUrl: './item.component.html',
  styleUrl: './item.component.css'
})
export class ItemComponent {
	constructor(public items : ItemService, public panier : PanierService, public users : UserService) { }

	addToCart(arg0: Item) {
		this.panier.addPanier(arg0);
	}

	removeFromCart(arg0: Item) {
	}

	deleteItem(arg0: Item) {
	}

	@Input() item! : Item;
}
