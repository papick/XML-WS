import { Component, OnInit, ViewChild } from '@angular/core';
import {AccomodationService} from '../../services/accomodation.service';
import {DatePickerComponent} from '../datepicker/datepicker.component';
import {Router} from '@angular/router';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  @ViewChild(DatePickerComponent) datePicker: DatePickerComponent;
  city : string;
  capacity : number;
  constructor(private accomodationService:AccomodationService, private router: Router) { }

  ngOnInit() {

  }

  find(){
    const searchBody = {
      capacity : this.capacity,
      city : this.city,
      fromDate : this.dateToString(this.datePicker.fromDate),
      toDate : this.dateToString(this.datePicker.toDate)
    }
    this.accomodationService.getAllAccomodationsBySearch(searchBody).subscribe(data =>{
      this.accomodationService.data = data;
      this.router.navigate(['accomodations']);

    })
  }

  private dateToString(date): string {
    let dateString: string;
    dateString = '' + date.year + '-' + date.month + '-' + date.day;
    return dateString;
  }


}
