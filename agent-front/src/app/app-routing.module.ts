import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {HomeComponent} from "./home/home.component";
import {AddEditAccomodationComponent} from "./add-edit-accomodation/add-edit-accomodation.component";
import {LogInComponent} from "./log-in/log-in.component";
import {AddReservationComponent} from "./add-reservation/add-reservation.component";
import {MessageComponent} from "./message/message.component";
import {ReservationsComponent} from "./reservations/reservations.component";
import {PriceListComponent} from "./price-list/price-list.component";

const routes: Routes = [
  {path: '', redirectTo: 'log-in', pathMatch: 'full'},
  {path: 'log-in', component: LogInComponent},
//  {path: ':username/reservations', component: ReservationsComponent},
  //{path: ':username/messages', component: MessageComponent},
  {path: ':username/:click', component: HomeComponent},
  {path: ':username/add/reservation', component: AddReservationComponent},
  {path: ':username/:mode/accomodation', component: AddEditAccomodationComponent},
  {path: ':username/:mode/accomodation/:id', component: AddEditAccomodationComponent},
  {path: ':username/price-list/:id/:name', component: PriceListComponent},

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
