import {Component} from "@angular/core";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {LogInModel} from "../../model/logIn.model";
import {LogInService} from "../../service/logInService";

@Component({
  templateUrl: './log-in.component.html',
})

export class LogInComponent {

  public form: FormGroup;
  public username: AbstractControl;
  public password: AbstractControl;
  agent;

  constructor(protected router: Router,
              private fb: FormBuilder,
              private logInService: LogInService) {
    this.form = this.fb.group({
      'username': ['', Validators.compose([Validators.required])],
      'password': ['', Validators.compose([Validators.required])],

    })
    this.username = this.form.controls['username'];
    this.password = this.form.controls['password'];


  }

  confirmClick() {
    const logIn = new LogInModel(
      this.username.value,
      this.password.value,
    );
    this.logInService.logIn(logIn).subscribe(data => {
      this.agent = data.agent;
      if (this.agent == null) {
        alert('Pogresna lozinka! Pokusajte ponovo.');
        this.form.controls['password'].setValue('');
      } else {
        this.router.navigateByUrl(this.agent.username +'/home');
      }
    })
  }
}
