import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AccomodationService } from '../../services/accomodation.service';
import {ReservationService} from '../../services/reservation.service';
import { UserService } from '../../services/user.service';
import {DatePickerComponent} from '../datepicker/datepicker.component';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';



@Component({
  selector: 'app-accomodation',
  templateUrl: './accomodation.component.html',
  styleUrls: ['./accomodation.component.css']
})
export class AccomodationComponent implements OnInit {

 @ViewChild(DatePickerComponent) datePicker : DatePickerComponent;
  accomodation : any={};
  displayDialog: boolean= false;

  fromDate: NgbDateStruct;
  toDate: NgbDateStruct ;
  constructor( private userService : UserService, private accomodationService :AccomodationService,
              private reservationService :ReservationService,  private route: ActivatedRoute) {
    }

  ngOnInit() {
    this.accomodation.type ={};
    this.accomodation.city={};
    this.accomodation.city.country={};
    const id=this.route.snapshot.params['id'];
    this.accomodationService.getAccomodation(id).subscribe(data => {
      this.accomodation = data;
      this.datePicker.periods = this.accomodation.periods;
      this.datePicker.ngOnInit();
    }, err=> console.log(err));
  }

  showDialog(){
    if( this.userService.getLoggedUser() == null){
        console.log("You must log in!");
        return;
    }
    console.log(JSON.stringify(this.accomodation.periods));
    this.fromDate = this.datePicker.fromDate;
    this.toDate = this.datePicker.toDate;

    this.displayDialog = true;
  }

  reserve(){
    const period ={
      fromDate: this.dateToString(this.fromDate),
      toDate : this.dateToString(this.toDate),
      accomodation : this.accomodation
    }

    const reservation = {period : period, user: this.userService.getLoggedUser()};

    this.reservationService.reserve(reservation).subscribe(data => {
      this.closeDialog();
    });


  }

  closeDialog(){
    this.displayDialog=false;
  }

  private dateToString(date): string{
    let dateString :string;
    dateString = ''+date.year+'/'+date.month+'/'+date.day;
    return dateString;
  }


}
