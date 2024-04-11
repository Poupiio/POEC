import { Item } from "./Item";

export interface UserDTO {
	id: number | undefined | null;
	name: string | undefined | null;
	email: string | undefined | null;
	password: string | undefined | null;
	age: number | undefined | null;
	panier : number | undefined | null;
}
