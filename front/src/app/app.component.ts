import { Component } from '@angular/core';

import {MenuItem} from 'primeng/api';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  items: MenuItem[];

  constructor(){
    this.items = [
      {label: 'Home', routerLink: ['/']},
      {label: 'Login',  routerLink: ['/login']},
      {label: 'Register',  routerLink: ['/register']},

    ]
  }

  logout(){
    console.log('Not Implemented');
  }
  
}
