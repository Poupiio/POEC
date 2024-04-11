import { Component, OnChanges, SimpleChanges } from '@angular/core';
import { ItemService } from '../../Service/item.service';
import { CommonModule } from '@angular/common';
import { ItemComponent } from '../item/item.component';
import { Item } from '../../Model/Item';

@Component({
  selector: 'app-item-list',
  standalone: true,
  imports: [CommonModule, ItemComponent],
  templateUrl: './item-list.component.html',
  styleUrl: './item-list.component.css'
})
export class ItemListComponent implements OnChanges {
	constructor(public items : ItemService) {
		this.getItems();
	}

	ngOnChanges(changes: SimpleChanges): void {
		this.getItems();
	}

	itemsList : Item[] = [];

	getItems() {
		this.items.getItems().subscribe((data) => {
			this.itemsList = data;
		});
	}
}
