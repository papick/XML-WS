import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {AccomodationService} from "../../service/accomodation.service";

@Component({
  selector: 'reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']

})
export class ReservationsComponent implements OnInit {


  constructor(protected route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {

  }

  addReservations() {
    const username = this.route.snapshot.params.username;
    this.router.navigateByUrl(username + '/add/reservation')

  }
}
