import {Component, OnInit} from '@angular/core';
import {UserService} from '../../services/userService';
import {Router} from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  active = false;
  users = [];

  constructor(private userService: UserService,
              private router: Router) {
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

  removeUser(id) {
    this.userService.remove(id).subscribe(data => {
      location.reload();
    });
  }

  activateUser(id) {
    this.userService.activateUser(id).subscribe(data => {
      location.reload();
    });
  }

  blockUser(id) {
    this.userService.blockUser(id).subscribe(data => {
      location.reload();
    });
  }

}
