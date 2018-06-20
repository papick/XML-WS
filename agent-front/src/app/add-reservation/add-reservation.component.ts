import {Component} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  templateUrl: './add-reservation.component.html',
})

export class AddReservationComponent {

  public form: FormGroup;
  public accomodation: AbstractControl;
  public from: AbstractControl;
  public to: AbstractControl;

  accomodations = []
  constructor(protected route: ActivatedRoute,
              private router: Router,
              private fb: FormBuilder) {
    this.form = this.fb.group({
      'accomodation': ['', Validators.compose([Validators.required])],
      'from': ['', Validators.compose([Validators.required])],
      'to': ['', Validators.compose([Validators.required])],
    })
    this.accomodation = this.form.controls['accomodation'];
    this.from = this.form.controls['from'];
    this.to = this.form.controls['to'];


  }

  exit(){
    const username = this.route.snapshot.params.username;
    this.router.navigateByUrl(username + '/reservations')
  }
}
