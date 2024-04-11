import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MessageComponent } from '../message/message.component';
import { UserComponent } from '../user/user.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, MessageComponent, UserComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontangu';
}
