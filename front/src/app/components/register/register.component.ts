import {Component,OnInit} from '@angular/core';
import {Validators,FormControl,FormGroup,FormBuilder} from '@angular/forms';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

    msgs: any[] = [];

    userform: FormGroup;

    submitted: boolean;

    constructor(private fb: FormBuilder) {}

    ngOnInit() {
        this.userform = this.fb.group({
            'username': new FormControl('', Validators.compose([Validators.required, Validators.minLength(3)])),
            'email': new FormControl('', Validators.compose([Validators.required, Validators.email])),
            'password': new FormControl('', Validators.compose([Validators.required, Validators.minLength(6)]))
        });
    }

    onSubmit(value: string) {
        this.submitted = true;
        this.msgs = [];
        this.msgs.push({severity:'info', summary:'Success', detail:'Form Submitted'});
    }

    get diagnostic() { return JSON.stringify(this.userform.value); }

}
