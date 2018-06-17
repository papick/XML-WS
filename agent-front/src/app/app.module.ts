import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app-routing.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HomeComponent} from "./home/home.component";
import {AccomodationService} from "../service/accomodation.service";
import {AccomodationComponent} from "./accomodation/accomodation.component";
import {CityService} from "../service/city.service";
import {CategoryService} from "../service/category.service";
import {TypeAccomodationService} from "../service/typeAccomodation.service";
import {AditionalServiceService} from "../service/aditionalService.service";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AccomodationComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,

  ],
  providers: [
    AccomodationService,
    CityService,
    CategoryService,
    TypeAccomodationService,
    AditionalServiceService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}