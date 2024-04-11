import { Component } from '@angular/core';
import { HeaderComponent } from '../header/header.component';
import { ItemListComponent } from '../item-list/item-list.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [HeaderComponent, ItemListComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

}
