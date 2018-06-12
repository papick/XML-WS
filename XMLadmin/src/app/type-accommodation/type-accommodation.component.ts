import {Component, OnInit} from '@angular/core';
import {TypeAccommodationService} from '../../services/typeAccommodationService';

@Component({
  selector: 'app-type-accommodation',
  templateUrl: './type-accommodation.component.html',
  styleUrls: ['./type-accommodation.component.css']
})
export class TypeAccommodationComponent implements OnInit {

  typesAccomodation = [];

  constructor(private typeService: TypeAccommodationService) {
    this.typeService.getTypes().subscribe(data => {
      this.typesAccomodation = data;
    });
  }

  ngOnInit() {

  }

}
