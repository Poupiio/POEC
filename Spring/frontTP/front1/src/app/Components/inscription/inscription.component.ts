import { Component } from '@angular/core';
import { LogsDTO } from '../../Model/logsDTO';
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { UserService } from '../../Service/user.service';
import { UserDTO } from '../../Model/UserDTO';

@Component({
  selector: 'app-inscription',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './inscription.component.html',
  styleUrl: './inscription.component.css'
})
export class InscriptionComponent {
	constructor(public user: UserService, public fb : FormBuilder) { }

	public connectionForm = this.fb.group({
		name: ['', [Validators.required]],
		password: ['', [Validators.required]],
		age: [0, [Validators.required]],
		email: ['', [Validators.required]]
	});

	onSubmit() {
		console.log(this.connectionForm.value);

		let user : UserDTO = {
			id : 0,
			name : this.connectionForm.value.name,
			email : this.connectionForm.value.email,
			password : this.connectionForm.value.password,
			age : this.connectionForm.value.age,
			panier : 0
		};

		this.user.inscription(user);
	}
}
