import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {TypeAccommodationService} from '../../services/typeAccommodationService';

@Component({
  selector: 'app-type-accomodation-form',
  templateUrl: './type-accomodation-form.component.html',
  styleUrls: ['./type-accomodation-form.component.css']
})
export class TypeAccomodationFormComponent implements OnInit {

  public form: FormGroup;
  public name: AbstractControl;

  typeAccomodation = {
    name: ''
  };

  methodName = 'Dodaj';

  constructor(protected route: ActivatedRoute, private fb: FormBuilder,
              private typeService: TypeAccommodationService,
              private router: Router) {

    this.form = this.fb.group({
      'name': ['', Validators.compose([Validators.required])],
    });

    this.name = this.form.controls['name'];
  }

  ngOnInit() {

    const method = this.route.snapshot.params.mode;

    if (method === 'edit') {
      this.methodName = 'Izmeni';
      const id = this.route.snapshot.params.id;
      this.typeService.getType(id).subscribe(data => {
        this.form.controls['name'].setValue(data.name);
      });
    } else if (method === 'add') {
      this.methodName = 'Dodaj';
    }

  }

  confirmClick() {
    if (this.methodName === 'Dodaj') {
      this.addTypeAccomodation();
    } else {
      this.editTypeAccomodation();
    }
  }

  addTypeAccomodation() {
    this.typeAccomodation.name = this.name.value;

    this.typeService.addTypeAccomodation(this.typeAccomodation).subscribe(data => {
        this.router.navigateByUrl('home/typeAccommodation');
      }
    );
  }

  editTypeAccomodation() {
    const id = this.route.snapshot.params.id;
    this.typeAccomodation.name = this.name.value;
    this.typeService.editType(this.typeAccomodation, id).subscribe(data => {
      this.router.navigateByUrl('home/typeAccommodation');
    });
  }

}
