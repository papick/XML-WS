import {Component, OnInit} from '@angular/core';
import {TypeAccommodationService} from '../../services/typeAccommodationService';
import {Router} from '@angular/router';

@Component({
  selector: 'app-type-accommodation',
  templateUrl: './type-accommodation.component.html',
  styleUrls: ['./type-accommodation.component.css']
})
export class TypeAccommodationComponent implements OnInit {

  typesAccomodation = [];

  constructor(private typeService: TypeAccommodationService,
              private router: Router) {
    this.typeService.getTypes().subscribe(data => {
      this.typesAccomodation = data;
    });
  }

  ngOnInit() {

  }

  add() {
    this.router.navigateByUrl('/home/typeAccomodationForm/add');
  }

  edit(id) {
    this.router.navigateByUrl('/home/typeAccomodationForm/edit/' + id);
  }

}
