import {Component, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {AccomodationService} from '../../services/accomodation.service';
import {ReservationService} from '../../services/reservation.service';
import {UserService} from '../../services/user.service';
import {DatePickerComponent} from '../datepicker/datepicker.component';
import {NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import {CommentsService} from "../../services/commentsService";
import {ReservationModel} from "../../model/reservation.model";


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


  fromDate: NgbDateStruct;
  toDate: NgbDateStruct;

  price: number;
  priceList: any;

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

    this.datePicker.fromDate = this.accomodationService.fromDate;
    this.datePicker.toDate = this.accomodationService.toDate;
    const id = this.route.snapshot.params['id'];
    this.getComments(id);

    this.accomodationService.getAccomodation(id).subscribe(data => {
      this.accomodation = data;
      const periods = this.accomodation.periods;
      //this.initCalendar(periods);
    }, err => console.log(err));

    this.accomodationService.getPriceList(id).subscribe(data => {
      this.priceList = data;
    })
  }

  showDialog() {
    if (this.userService.getLoggedUser() == null) {
      alert("You must log in!");
      return;
    }

    this.fromDate = this.datePicker.fromDate;
    this.toDate = this.datePicker.toDate;

    this.price = 0;
    let d = new Date(this.fromDate.year, this.fromDate.month, this.fromDate.day);
    let to = new Date(this.toDate.year, this.toDate.month, this.toDate.day)
    while (d <= to) {
      this.priceList.forEach((monthPrice, index, arr) => {
        if (Number.parseInt(monthPrice.month) == d.getMonth()) {

          this.price += Number.parseInt(monthPrice.sum);
        }
      });
      d.setDate(d.getDate() + 1);
    }

    this.displayDialog = true;
  }

  reserve() {
    const reservations = new ReservationModel(
      this.userService.getLoggedUser().username,
      this.route.snapshot.params.id,
      this.dateToString(this.fromDate),
      this.dateToString(this.toDate),
    );

console.log( this.userService.getLoggedUser().username)




    this.reservationService.reserve(reservations).subscribe(data => {
      this.closeDialog();
    }, err => {
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

  stringToDate(dateString: string): Date {
    const splitted = dateString.split("-");
    const date = new Date(Number.parseInt(splitted[0]), Number.parseInt(splitted[1]), Number.parseInt(splitted[2]));
    return date;
  }

  getComments(id) {
    this.commService.getComments(id).subscribe(data => {
      this.comms = data;
    });
  }


  initCalendar(periods) {
    this.minDate = new Date();
    this.invalidDates = [];
    let period;
    periods.forEach((period, index, arr) => {
      const reservedFromDate = this.stringToDate(period.fromDate);
      const reservedToDate = this.stringToDate(period.toDate);
      let d = reservedFromDate;
      while (d <= reservedToDate) {

        this.invalidDates.push(new Date(d));

        d.setDate(d.getDate() + 1);
      }
    });

  }


}
