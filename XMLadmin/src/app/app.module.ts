import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {APP_BASE_HREF} from '@angular/common';

import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ReactiveFormsModule} from '@angular/forms';

import {FormsModule} from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { LogInComponent } from './log-in/log-in.component';
import { UsersComponent } from './users/users.component';
import { AgentsComponent } from './agents/agents.component';
import { TypeAccommodationComponent } from './type-accommodation/type-accommodation.component';
import { CategoryComponent } from './category/category.component';
import { AdditionalServiceComponent } from './additional-service/additional-service.component';
import { CommentsComponent } from './comments/comments.component';
import {TypeAccommodationService} from '../services/typeAccommodationService';
import {CategoryService} from '../services/categoryService';
import {AdditionalServiceService} from '../services/additionalServiceService';
import {UserService} from '../services/userService';
import {AgentService} from '../services/agentService';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LogInComponent,
    UsersComponent,
    AgentsComponent,
    TypeAccommodationComponent,
    CategoryComponent,
    AdditionalServiceComponent,
    CommentsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  providers: [
    {provide: APP_BASE_HREF, useValue: '/'},
    TypeAccommodationService,
    CategoryService,
    AdditionalServiceService,
    UserService,
    AgentService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
