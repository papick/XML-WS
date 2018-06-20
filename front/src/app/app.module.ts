import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { ProfileComponent } from './components/profile/profile.component';

import { routes } from './app.router';

import {GrowlModule} from 'primeng/growl';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';
import {PanelModule} from 'primeng/panel';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ButtonModule} from 'primeng/button';
import {MenubarModule} from 'primeng/menubar';
import {InputTextModule} from 'primeng/inputtext';
import {DataViewModule} from 'primeng/dataview';
import {NgbdDatepickerPopup} from "./components/datepicker-popup/datepicker-popup";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    NgbdDatepickerPopup,

  ],
  imports: [
    routes,
    BrowserModule,
    BrowserAnimationsModule,
    GrowlModule,
    FormsModule,
    ReactiveFormsModule,
    PanelModule,
    ButtonModule,
    MenubarModule,
    InputTextModule,
    DataViewModule,
    NgbModule.forRoot(),

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
