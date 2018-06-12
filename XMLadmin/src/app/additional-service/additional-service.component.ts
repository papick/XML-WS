import { Component, OnInit } from '@angular/core';
import {AdditionalServiceService} from '../../services/additionalServiceService';

@Component({
  selector: 'app-additional-service',
  templateUrl: './additional-service.component.html',
  styleUrls: ['./additional-service.component.css']
})
export class AdditionalServiceComponent implements OnInit {

  additionalservices = [];

  constructor(private addServiceService: AdditionalServiceService) {
    this.addServiceService.getAdditionalServices().subscribe(data => {
      this.additionalservices = data;
    });
  }

  ngOnInit() {
  }

}
