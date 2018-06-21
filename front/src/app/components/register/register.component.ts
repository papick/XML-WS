import {Component,OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Validators,FormControl,FormGroup,FormBuilder} from '@angular/forms';
import {UserService} from './../../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

    msgs: any[] = [];

    userform: FormGroup;

    submitted: boolean;

    constructor(private fb: FormBuilder,private userService : UserService, private router :Router) {}

    ngOnInit() {
        this.userform = this.fb.group({
            'username': new FormControl('', Validators.compose([Validators.required, Validators.minLength(3)])),
            'email': new FormControl('', Validators.compose([Validators.required, Validators.email])),
            'password': new FormControl('', Validators.compose([Validators.required, Validators.minLength(6)]))
        });
    }

    onSubmit(value: string) {
      console.log(value);
        this.submitted = true;
        this.msgs = [];
        this.msgs.push({severity:'info', summary:'Success', detail:'User Submitted'});
        this.userService.register(value).subscribe( data=>{
          this.router.navigate(['/login']);
        });
    }

    get diagnostic() { return JSON.stringify(this.userform.value); }

}
