import { Routes } from '@angular/router';
import { HomeComponent } from './Components/home/home.component';
import { ItemComponent } from './Components/item/item.component';
import { InscriptionComponent } from './Components/inscription/inscription.component';
import { ConnectionComponent } from './Components/connection/connection.component';
import { CartComponent } from './Components/cart/cart.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component:  HomeComponent},
  { path: 'item', component:  ItemComponent},
  { path: 'inscription', component:  InscriptionComponent},
  { path: 'connection', component:  ConnectionComponent},
  { path: 'cart', component: CartComponent}
];
