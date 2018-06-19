import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";
import {HomeComponent} from "./home/home.component";
import {AccomodationComponent} from "./accomodation/accomodation.component";
import {LogInComponent} from "./log-in/log-in.component";

const routes: Routes = [
  {path: '', redirectTo: 'log-in', pathMatch: 'full'},
  {path: 'log-in', component: LogInComponent},
  {path: ':id/home', component: HomeComponent},
  {path: ':mode/accomodation', component: AccomodationComponent},
  {path: ':mode/accomodation/:id', component: AccomodationComponent},
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
