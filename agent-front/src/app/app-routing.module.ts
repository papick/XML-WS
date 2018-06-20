import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {HomeComponent} from "./home/home.component";
import {AddEditAccomodationComponent} from "./add-edit-accomodation/add-edit-accomodation.component";
import {LogInComponent} from "./log-in/log-in.component";
import {AddReservationComponent} from "./add-reservation/add-reservation.component";

const routes: Routes = [
  {path: '', redirectTo: 'log-in', pathMatch: 'full'},
  {path: 'log-in', component: LogInComponent},
  {path: ':username/:click', component: HomeComponent},
  {path: ':username/add/reservation', component: AddReservationComponent},
  {path: ':username/:mode/accomodation', component: AddEditAccomodationComponent},
  {path: ':username/:mode/accomodation/:id', component: AddEditAccomodationComponent},
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
