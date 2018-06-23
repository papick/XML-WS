import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {AccomodationService} from '../../services/accomodation.service';
import {ReservationService} from '../../services/reservation.service';
import {UserService} from '../../services/user.service';
import {DatePickerComponent} from '../datepicker/datepicker.component';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import {CommentsService} from "../../services/commentsService";


@Component({
  selector: 'app-accomodation',
  templateUrl: './accomodation.component.html',
  styleUrls: ['./accomodation.component.css']
})
export class AccomodationComponent implements OnInit {

  @ViewChild(DatePickerComponent) datePicker: DatePickerComponent;
  accomodation: any = {};
  displayDialog: boolean = false;

  comms = [];
  commentText : string;

  fromDate: NgbDateStruct;
  toDate: NgbDateStruct;

  minDate: Date;
  invalidDates: Array<Date>

  constructor(private userService: UserService, private accomodationService: AccomodationService,
              private reservationService: ReservationService, private route: ActivatedRoute, private  commService: CommentsService) {
  }

  ngOnInit() {
    this.accomodation.type = {};
    this.accomodation.city = {};
    this.accomodation.city.country = {};
    this.accomodation.category = {};

    const id = this.route.snapshot.params['id'];
    this.getComments(id);
    this.accomodationService.getAccomodation(id).subscribe(data => {
      this.accomodation = data;
      const periods = this.accomodation.periods;
      this.initCalendar(periods);
    }, err => console.log(err));
  }

  showDialog() {
    if (this.userService.getLoggedUser() == null) {
      alert("You must log in!");
      return;
    }
    this.fromDate = this.datePicker.fromDate;
    this.toDate = this.datePicker.toDate;

    this.displayDialog = true;
  }

  reserve() {
    const period = {
      fromDate: this.dateToString(this.fromDate),
      toDate: this.dateToString(this.toDate),
      accomodation: this.accomodation
    }

    const reservation = {period: period, user: this.userService.getLoggedUser()};

    this.reservationService.reserve(reservation).subscribe(data => {
      this.closeDialog();
    }, err =>{
      alert('Already reserved');
    });


  }

  closeDialog() {
    this.displayDialog = false;
  }

   dateToString(date): string {
    let dateString: string;
    dateString = '' + date.year + '-' + date.month + '-' + date.day;
    return dateString;
  }

  stringToDate(dateString:string):Date  {
    const splitted = dateString.split("-");
    const date =  new Date(Number.parseInt( splitted[0]), Number.parseInt( splitted[1]),Number.parseInt(  splitted[2]));
    return date;
  }

  getComments(id) {
    this.commService.getComments(id).subscribe(data => {
      this.comms = data;
    });
  }

  comment(){
    const comment = {
      text: this.commentText,
      accommodation: this.accomodation,
      nameOfUser: this.userService.getLoggedUser().username
    };
    this.commService.addComment(comment).subscribe(data => {
      alert('Comment will be placed after adminstrator review');
    });
  }

  initCalendar(periods){
    this.minDate = new Date();
    this.invalidDates = [];
    let period;
     periods.forEach( (period, index, arr)=>{
       const reservedFromDate = this.stringToDate(period.fromDate);
       const reservedToDate = this.stringToDate(period.toDate);
       console.log(JSON.stringify(reservedFromDate));

       let d = reservedFromDate;
       /*while(d <= reservedToDate){

         this.invalidDates.push(d);

         d = new Date(d.getDate() + 1);
       }*/
     });

    }



}
