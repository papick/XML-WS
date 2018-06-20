import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app-routing.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HomeComponent} from "./home/home.component";
import {AccomodationService} from "../service/accomodation.service";
import {AddEditAccomodationComponent} from "./add-edit-accomodation/add-edit-accomodation.component";
import {CityService} from "../service/city.service";
import {CategoryService} from "../service/category.service";
import {TypeAccomodationService} from "../service/typeAccomodation.service";
import {AditionalServiceService} from "../service/aditionalService.service";
import {LogInComponent} from './log-in/log-in.component';
import {LogInService} from "../service/logInService";
import {AccomodationsComponent} from "./accomodations/accomodations.component";
import {NgbdDatepickerPopup} from "./datepicker-popup/datepicker-popup";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AddEditAccomodationComponent,
    LogInComponent,
    AccomodationsComponent,
    NgbdDatepickerPopup,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    NgbModule.forRoot(),

  ],
  providers: [
    AccomodationService,
    CityService,
    CategoryService,
    TypeAccomodationService,
    AditionalServiceService,
    LogInService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
