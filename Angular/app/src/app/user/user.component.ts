import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { UserToGet } from 'src/types';

@Component({
  selector: 'app-user',
  templateUrl: "./user.component.html",
  styles: [ ``
  ]
})
export class UserComponent implements OnInit {
  users: UserToGet[] = [];
  user: UserToGet | undefined;

  constructor(
    private userService: UserService
  ) { }

  ngOnInit(): void {
    this.getUsers();
    
  }

  async getUsers() {
    this.userService.getUsers().subscribe(res => {
      this.users = res;
      console.log(res);
    });
  }

  async getUserById(id: number) {
    this.userService.getUserById(id).subscribe(res => {
      this.user = res;
      console.log(res);
    });
  }

}
