import { Item } from "./Item";
import { Panier } from "./Panier";

export interface User {
	id: number;
	name: string;
	email: string
	password: string;
	age: number;
	panier : Panier;
}
