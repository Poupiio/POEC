import { Component } from '@angular/core';
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { UserService } from '../../Service/user.service';
import { LogsDTO } from '../../Model/logsDTO';

@Component({
  selector: 'app-connection',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule],
  templateUrl: './connection.component.html',
  styleUrl: './connection.component.css'
})
export class ConnectionComponent {

	constructor(public user: UserService, public fb : FormBuilder) { }

	public connectionForm = this.fb.group({
		name: ['', [Validators.required]],
		password: ['', [Validators.required]]
	});

	onSubmit() {
		console.log(this.connectionForm.value);

		let user : LogsDTO = {
			name: this.connectionForm.value.name,
			password: this.connectionForm.value.password
		}

		this.user.connectUser(user);

	}

}
