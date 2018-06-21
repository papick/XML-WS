import { Component, OnInit } from '@angular/core';
import {AccomodationService} from '../../services/accomodation.service'

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  accomodations : any;

  constructor(private accomodationService:AccomodationService) { }

  ngOnInit() {
    this.accomodationService.getAllAccomodations().subscribe(data =>{
      this.accomodations = data;
    });
  }



}
