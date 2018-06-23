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
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {ReservationsComponent} from "./reservations/reservations.component";
import {AddReservationComponent} from "./add-reservation/add-reservation.component";
import {ReservationService} from "../service/reservation.service";
import {PeriodService} from "../service/period.service";
import {MessageComponent} from "./message/message.component";
import {MessageService} from "../service/message.service";
import {PriceListComponent} from "./price-list/price-list.component";
import {PriceListService} from "../service/priceList.service";
import {CommentComponent} from "./comment/commentComponent";
import {CommentService} from "../service/comment.service";


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AddEditAccomodationComponent,
    LogInComponent,
    AccomodationsComponent,
    NgbdDatepickerPopup,
    ReservationsComponent,
    AddReservationComponent,
    MessageComponent,
    PriceListComponent,
    CommentComponent,

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
    ReservationService,
    PeriodService,
    MessageService,
    PriceListService,
    CommentService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
