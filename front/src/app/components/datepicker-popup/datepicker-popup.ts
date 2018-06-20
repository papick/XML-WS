import {Component, Input} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup} from "@angular/forms";
import { ChangeDetectorRef } from '@angular/core';
import {element} from "protractor";

@Component({
  selector: 'ngbd-datepicker-popup',
  templateUrl: './datepicker-popup.html',
  styleUrls: ['./datepicker-popup.css'],
  host: {
    "[attr.date]" : "date"
  }
})
export class NgbdDatepickerPopup {



  model : any;


  date: any = 'undefined-undefined-undefined';

  public form: FormGroup;
  public dateInput: AbstractControl;

  constructor(private fb: FormBuilder,
              private cdRef: ChangeDetectorRef ){

    this.form = this.fb.group({
      'dateInput' : [''],
    })

    this.dateInput = this.form.controls['dateInput'];


  }

  change() {

    var dat = [];


    for(let prop in this.model) {
      console.log(this.model[prop]);
      dat.push(this.model[prop]);
    }

    this.date = dat[0] + '-' + dat[1] + '-' + dat[2];


    console.log(this.date)
    this.cdRef.detectChanges();
    this.message.next('all done loading');
  }



}
