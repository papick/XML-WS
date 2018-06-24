import { Component, OnInit, ViewChild } from '@angular/core';
import {AccomodationService} from '../../services/accomodation.service';
import {DataSearchService} from "../../services/dataSearch.service";

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

  checkedAdvanced : boolean;
  categories : any;
  types : any;
  additions : any;
  selectedCategories : any;
  selectedTypes : any;
  selectedAdditions: any;

  constructor(private accomodationService:AccomodationService, private dataSearch:DataSearchService , private router: Router) { }

  ngOnInit() {
    this.dataSearch.getAllCategories().subscribe(data => {
      this.categories = data;
    })
    this.dataSearch.getAllTypes().subscribe(data => {
      this.types = data;
    })
    this.dataSearch.getAllAdditions().subscribe(data => {
      this.additions = data;
    })
  }

  find(){

    if(this.checkedAdvanced){
      const searchBody = {
        capacity : this.capacity,
        city : this.city,
        fromDate : this.dateToString(this.datePicker.fromDate),
        toDate : this.dateToString(this.datePicker.toDate),
        categories : this.selectedCategories,
        types : this.selectedTypes,
        additions : this.selectedAdditions
      }
      this.accomodationService.getAllAccomodationsByAdvancedSearch(searchBody).subscribe(data =>{
        this.accomodationService.data = data;
        this.accomodationService.fromDate =  this.datePicker.fromDate
        this.accomodationService.toDate =  this.datePicker.toDate

        this.router.navigate(['accomodations']);
      })
    }else{
      const searchBody = {
        capacity : this.capacity,
        city : this.city,
        fromDate : this.dateToString(this.datePicker.fromDate),
        toDate : this.dateToString(this.datePicker.toDate)
      }
      this.accomodationService.getAllAccomodationsBySearch(searchBody).subscribe(data =>{
        this.accomodationService.data = data;

        this.accomodationService.fromDate =  this.datePicker.fromDate
        this.accomodationService.toDate =  this.datePicker.toDate
        this.router.navigate(['accomodations']);
      })
    }
  }

  private dateToString(date): string {
    let dateString: string;
    dateString = '' + date.year + '-' + date.month + '-' + date.day;
    return dateString;
  }


}
