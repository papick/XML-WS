import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  public form: FormGroup;
  public username: AbstractControl;
  public password: AbstractControl;

  imageRoute = '../../../assets/images/login.jpg';

  constructor(protected router: Router,
              private fb: FormBuilder) {
    this.form = this.fb.group({
      'username': ['', Validators.compose([Validators.required])],
      'password': ['', Validators.compose([Validators.required])],

    });
    this.username = this.form.controls['username'];
    this.password = this.form.controls['password'];
  }

  ngOnInit() {
  }

  confirmClick() {
    if (this.username.value === 'admin' && this.password.value === 'admin') {
      this.router.navigateByUrl('/home');
    } else {
      console.log('Bad pass or username');
    }
  }

}
