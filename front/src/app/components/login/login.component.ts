import {Component,OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Validators,FormControl,FormGroup,FormBuilder} from '@angular/forms';
import { UserService } from '../../services/user.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    msgs: any[] = [];

    userform: FormGroup;

    submitted: boolean;

    constructor(private fb: FormBuilder, private userService: UserService, private router: Router) {}

    ngOnInit() {
        this.userform = this.fb.group({
            'username': new FormControl('', Validators.compose([Validators.required, Validators.minLength(3)])),
            'password': new FormControl('', Validators.compose([Validators.required, Validators.minLength(6)])),
        });


    }

    onSubmit(value: string) {
        this.submitted = true;
        this.msgs = [];
        this.msgs.push({severity:'info', summary:'Success', detail:'User Login Submitted'});
        this.userService.login(value).subscribe( data=>{
          sessionStorage.setItem('user', JSON.stringify(value));
          this.router.navigate(['']);
        });
    }

    get diagnostic() { return JSON.stringify(this.userform.value); }

}
