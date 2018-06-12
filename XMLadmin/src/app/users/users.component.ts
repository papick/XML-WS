import {Component, OnInit} from '@angular/core';
import {UserService} from '../../services/userService';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  active = false;
  users = [];

  constructor(private userService: UserService) {
  }

  ngOnInit() {
  }

  getAct() {
    this.active = true;
    this.userService.getActiveUsers().subscribe(data => {
      this.users = data;
    });
  }

  getBlock() {
    this.active = false;
    this.userService.getBlockedUsers().subscribe(data => {
      this.users = data;
    });
  }

}
