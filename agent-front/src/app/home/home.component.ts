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
  message = false;

  constructor(protected route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    const click = this.route.snapshot.params.click;
    if (click === 'home') {
      this.accomodations = true;
      this.reservations = false;
      this.message = false;
    } else if (click === 'reservations') {
      this.accomodations = false;
      this.reservations = true;
      this.message = false;
    } else if (click === 'message') {
      this.accomodations = false;
      this.reservations = false;
      this.message = true;
    }

    console.log(localStorage.getItem('agentId'))
  }

  accomodationsClick() {
    this.accomodations = true;
    this.reservations = false;
    this.message = false;
  }

  reservationsClick() {
    this.accomodations = false;
    this.reservations = true;
    this.message = false;
  }

  messageClick() {
    this.accomodations = false;
    this.reservations = false;
    this.message = true;

  }

  logOut() {
    this.router.navigateByUrl('');
  }
}
