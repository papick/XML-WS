import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';
import {AgentService} from '../../services/agentService';

@Component({
  selector: 'app-agent-form',
  templateUrl: './agent-form.component.html',
  styleUrls: ['./agent-form.component.css']
})
export class AgentFormComponent implements OnInit {


  public form: FormGroup;
  public username: AbstractControl;
  public password: AbstractControl;
  public name: AbstractControl;
  public surname: AbstractControl;
  public address: AbstractControl;
  public mbr: AbstractControl;

  sklj;

  agent = {
    username: '',
    password: '',
    surname: '',
    name: '',
    address: '',
    mbr: ''
  };

  constructor(protected router: Router,
              private fb: FormBuilder,
              private agentService: AgentService) {
    this.form = this.fb.group({
      'username': ['', Validators.compose([Validators.required])],
      'password': ['', Validators.compose([Validators.required])],
      'name': ['', Validators.compose([Validators.required])],
      'surname': ['', Validators.compose([Validators.required])],
      'address': ['', Validators.compose([Validators.required])],
      'mbr': ['', Validators.compose([Validators.required])],

    });
    this.username = this.form.controls['username'];
    this.password = this.form.controls['password'];
    this.name = this.form.controls['name'];
    this.surname = this.form.controls['surname'];
    this.address = this.form.controls['address'];
    this.mbr = this.form.controls['mbr'];

  }

  ngOnInit() {
  }

  add() {
    this.agent.name = this.name.value;
    this.agent.surname = this.surname.value;
    this.agent.username = this.username.value;
    this.agent.password = this.password.value;
    this.agent.address = this.address.value;
    this.agent.mbr = this.mbr.value;

    this.agentService.addAgent(this.agent).subscribe(data => {
      this.sklj = data;
      this.router.navigateByUrl('/home/agents');
    });

  }}
