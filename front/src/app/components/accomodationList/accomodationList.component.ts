import { Component, OnInit } from '@angular/core';
import {AccomodationService} from '../../services/accomodation.service'

@Component({
  selector: 'accomodation-list',
  templateUrl: './accomodationList.component.html',
  styleUrls: ['./accomodationList.component.css']
})
export class AccomodationListComponent implements OnInit {

  accomodations : any;

  constructor(private accomodationService:AccomodationService) { }

  ngOnInit() {

      this.accomodations =this.accomodationService.data;

  }



}
