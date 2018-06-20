import {Component} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']

})
export class ReservationsComponent {

  constructor(protected route: ActivatedRoute,
              private router: Router) {
  }

  addReservations(){
    const username = this.route.snapshot.params.username;
    this.router.navigateByUrl(username + '/add/reservation')

  }
}
