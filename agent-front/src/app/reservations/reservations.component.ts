import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {AccomodationService} from "../../service/accomodation.service";
import {ReservationService} from "../../service/reservation.service";
import {PeriodService} from "../../service/period.service";

@Component({
  selector: 'reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']

})
export class ReservationsComponent implements OnInit {


  periods = [];
  reservations = [];

  constructor(protected route: ActivatedRoute,
              private router: Router,
              private periodService: PeriodService,
              private reservationService: ReservationService) {
  }

  ngOnInit() {

    this.periodService.getPeriods().subscribe(data => {
      this.periods = data;
    })

    this.reservationService.getReservations().subscribe(data => {
      this.reservations = data;
    })
  }

  addReservations() {
    const username = this.route.snapshot.params.username;
    this.router.navigateByUrl(username + '/add/reservation')

  }
}
