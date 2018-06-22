import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';


import {AppComponent} from './app.component';
import {LoginComponent} from './components/login/login.component';
import {RegisterComponent} from './components/register/register.component';
import {HomeComponent} from './components/home/home.component';
import {ProfileComponent} from './components/profile/profile.component';
import {AccomodationComponent} from './components/accomodation/accomodation.component';
import {AccomodationListComponent} from './components/accomodationList/accomodationList.component';

import {DatePickerComponent} from './components/datepicker/datepicker.component'

import {UserService} from './services/user.service'
import {AccomodationService} from './services/accomodation.service';
import {ReservationService} from './services/reservation.service';

import {routes} from './app.router';

import {GrowlModule} from 'primeng/growl';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {PanelModule} from 'primeng/panel';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ButtonModule} from 'primeng/button';
import {MenubarModule} from 'primeng/menubar';
import {InputTextModule} from 'primeng/inputtext';
import {DataViewModule} from 'primeng/dataview';
import {NgbdDatepickerPopup} from "./components/datepicker-popup/datepicker-popup";
import {CardModule} from 'primeng/card';
import {DialogModule} from 'primeng/dialog';
import {InputTextareaModule} from 'primeng/inputtextarea';
import {KeyFilterModule} from 'primeng/keyfilter';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {MessageService} from "./services/message.service";
import {MessagesComponent} from "./components/messages/messages.component";

import {CommentsService} from "./services/commentsService";


import {VoteService} from "./services/vote.service";


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    NgbdDatepickerPopup,
    AccomodationComponent,
    DatePickerComponent,
    MessagesComponent,
    AccomodationListComponent


  ],
  imports: [
    routes,
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    GrowlModule,
    FormsModule,
    ReactiveFormsModule,
    PanelModule,
    ButtonModule,
    MenubarModule,
    InputTextModule,
    DataViewModule,
    CardModule,
    DialogModule,
    InputTextareaModule,
    KeyFilterModule,
    NgbModule.forRoot(),

  ],
  providers: [
    UserService,
    AccomodationService,
    ReservationService,
    MessageService,
    CommentsService,
    VoteService

  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
