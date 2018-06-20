import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AccomodationService} from "../../service/accomodation.service";
import {ReservationModel} from "../../model/reservation.model";

@Component({
  templateUrl: './add-reservation.component.html',
})

export class AddReservationComponent implements OnInit {

  public form: FormGroup;
  public accomodation: AbstractControl;
  public from: AbstractControl;
  public to: AbstractControl;

  accomodations = []

  constructor(protected route: ActivatedRoute,
              private router: Router,
              private fb: FormBuilder,
              private accomodationService: AccomodationService) {
    this.form = this.fb.group({
      'accomodation': ['', Validators.compose([Validators.required])],
      'from': ['', Validators.compose([Validators.required])],
      'to': ['', Validators.compose([Validators.required])],
    })
    this.accomodation = this.form.controls['accomodation'];
    this.from = this.form.controls['from'];
    this.to = this.form.controls['to'];


  }

  ngOnInit() {
    this.accomodationService.getAccomodations().subscribe(data => {
      this.accomodations = data.accomodations;
    })
  }

  reservation():any {
    const reservation = new ReservationModel(
      this.accomodation.value,
      this.from.value,
      this.to.value,

    );

    /*this.reservationService.createReservation(reservation).subscribe(data => {
      const username = this.route.snapshot.params.username;
      this.router.navigateByUrl(username + '/reservations');

    })*/

  }
  exit() {
    const username = this.route.snapshot.params.username;
    this.router.navigateByUrl(username + '/reservations')
  }
}
