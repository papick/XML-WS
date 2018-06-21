import { Component } from '@angular/core';
import { Router } from '@angular/router';
import {MenuItem} from 'primeng/api';
import { UserService } from './services/user.service';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  title = 'app';
  items: MenuItem[];

  constructor(private userService : UserService, private router : Router){
    this.items = [
      {label: 'Home', routerLink: ['/']}
    ]
  }

  isLogged(){
    return this.userService.getLoggedUser() != null;
  }

  getUsername(){
    return this.userService.getLoggedUser().username;
  }
  logout(){
    sessionStorage.clear();
    this.userService.logout().subscribe(data =>{
      this.router.navigate(['']);
    });
  }

}
