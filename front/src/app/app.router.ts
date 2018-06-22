import {ModuleWithProviders} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {LoginComponent} from './components/login/login.component';
import {HomeComponent} from './components/home/home.component';
import {RegisterComponent} from './components/register/register.component';
import {ProfileComponent} from './components/profile/profile.component';
import { AccomodationComponent } from './components/accomodation/accomodation.component';
import {MessagesComponent} from "./components/messages/messages.component";


export const router: Routes = [
  {path: '', redirectTo:"home" , pathMatch: 'full'},
  {path: 'home',component: HomeComponent },
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'profiles/:username', component: ProfileComponent},
  {path: 'accomodations/:id', component: AccomodationComponent},
  {path: 'profiles/:username/messages', component: MessagesComponent}
];


export const routes: ModuleWithProviders = RouterModule.forRoot(router);
