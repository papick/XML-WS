import {ExtraOptions, RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {LogInComponent} from './log-in/log-in.component';


const routes: Routes = [
  /*{path: '', component: },*/
  {path: '', redirectTo: 'log-in', pathMatch: 'full'},
  {path: 'log-in', component: LogInComponent},
  {path: 'home', component: HomeComponent},
  {path: 'home/:click', component: HomeComponent},
  {path: 'home/:click/:mode', component: HomeComponent},
  {path: 'home/:click/:mode/:id', component: HomeComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
