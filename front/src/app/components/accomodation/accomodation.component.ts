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

  constructor(private userService: UserService, private accomodationService: AccomodationService,
              private reservationService: ReservationService, private route: ActivatedRoute, private  commService: CommentsService) {
  }

  ngOnInit() {
    this.accomodation.type = {};
    this.accomodation.city = {};
    this.accomodation.city.country = {};
    const id = this.route.snapshot.params['id'];
    this.getComments(id);
    this.accomodationService.getAccomodation(id).subscribe(data => {
      this.accomodation = data;
      this.datePicker.periods = this.accomodation.periods;
      this.datePicker.ngOnInit();
    }, err => console.log(err));
  }

  showDialog() {
    if (this.userService.getLoggedUser() == null) {
      console.log("You must log in!");
      return;
    }
    console.log(JSON.stringify(this.accomodation.periods));
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

  private dateToString(date): string {
    let dateString: string;
    dateString = '' + date.year + '-' + date.month + '-' + date.day;
    return dateString;
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


}
