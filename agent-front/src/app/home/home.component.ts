import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {AccomodationService} from "../../service/accomodation.service";

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {

  accomodations = false;
  reservations = false;

  constructor(protected route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    const click = this.route.snapshot.params.click;
    if (click === 'home') {
      this.accomodations = true;
      this.reservations = false;
    } else if (click === 'reservations') {
      this.accomodations = false;
      this.reservations = true;
    }

  }

  accomodationsClick() {
    this.accomodations = true;
    this.reservations = false;
  }

  reservationsClick(){
    this.accomodations = false;
    this.reservations = true;
  }
}
