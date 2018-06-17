import {Component, OnInit} from "@angular/core";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {CityService} from "../../service/city.service";
import {CategoryService} from "../../service/category.service";
import {TypeAccomodationService} from "../../service/typeAccomodation.service";
import {AditionalServiceService} from "../../service/aditionalService.service";
import {AccomodationModel} from "../../model/accomodation.model";
import {AccomodationService} from "../../service/accomodation.service";

@Component({
  selector: 'accomodation',
  templateUrl: './accomodation.component.html',

})

export class AccomodationComponent implements OnInit {

  public form: FormGroup;
  public name: AbstractControl;
  public category: AbstractControl;
  public city: AbstractControl;
  public address: AbstractControl;
  public description: AbstractControl;
  public capacity: AbstractControl;
  public price: AbstractControl;
  public type: AbstractControl;
  public aditional: AbstractControl;

  public method_name = 'DODAJ';

  categories = []
  cities = []
  types = []
  services = []


  constructor(protected router: Router,
              private fb: FormBuilder,
              private route: ActivatedRoute,
              private cityService: CityService,
              private categoryService: CategoryService,
              private typeAccomodation: TypeAccomodationService,
              private aditionalService: AditionalServiceService,
              private accomodationService: AccomodationService) {
    this.form = this.fb.group({
      'name': ['', Validators.compose([Validators.required])],
      'category': [''],
      'city': [''],
      'address': [''],
      'description': [''],
      //, Validators.pattern('[0-9]{2}\:[0-9]{2}')
      'capacity': ['', Validators.compose([Validators.required])],
      'price': ['', Validators.compose([Validators.required])],
      'type': [''],
      'aditional': [''],

    })
    this.name = this.form.controls['name'];
    this.category = this.form.controls['category'];
    this.price = this.form.controls['price'];
    this.address = this.form.controls['address'];
    this.description = this.form.controls['description'];
    this.capacity = this.form.controls['capacity'];
    this.city = this.form.controls['city'];
    this.type = this.form.controls['type'];
    this.aditional = this.form.controls['aditional'];


  }

  ngOnInit() {
    const mode = this.route.snapshot.params.mode;

    this.cityService.getCities().subscribe(data => {
      this.cities = data.cities;
    })

    this.categoryService.getCategories().subscribe(data => {
      this.categories = data.categories;
    })

    this.aditionalService.getAditionalServices().subscribe(data => {
      this.services = data.services;
    })

    this.typeAccomodation.getTypeAccomodations().subscribe(data => {
      this.types = data.types;
    })

    if (mode == 'edit') {
      this.method_name = 'IZMENI';
      const id = this.route.snapshot.params.id;

      this.accomodationService.getAccomodation(id).subscribe(data => {
        this.form.controls['name'].setValue(data.name);
        this.form.controls['category'].setValue(data.category.name);
        this.form.controls['city'].setValue(data.city.name);
        this.form.controls['address'].setValue(data.address);
        this.form.controls['description'].setValue(data.description);
        this.form.controls['capacity'].setValue(data.capacity);
        this.form.controls['price'].setValue(data.price);
        this.form.controls['type'].setValue(data.type.name);

      })


    } else if (mode == 'add') {
    }


  }

  confirmClick() {
    if (this.method_name === 'DODAJ') {
      this.createAccomodation();
    } else {
      this.editAccomodatin();
    }
  }

  createAccomodation(): any {

    const accomodation = new AccomodationModel(
      this.description.value,
      this.type.value,
      this.name.value,
      this.city.value,
      this.address.value,
      this.category.value,
      this.capacity.value,
      this.price.value,
    );

    this.accomodationService.createAccomodation(accomodation, 1).subscribe(data => {
      this.router.navigateByUrl('home');

    })

  }

  editAccomodatin() {
    const accomodation = new AccomodationModel(
      this.description.value,
      this.type.value,
      this.name.value,
      this.city.value,
      this.address.value,
      this.category.value,
      this.capacity.value,
      this.price.value,
    );
    const id = this.route.snapshot.params.id;
    this.accomodationService.editAccomodation(accomodation, 1, id).subscribe(data => {
      this.router.navigateByUrl('home');
    })
  }

  exit() {
    const idBank = this.route.snapshot.params.idBank;
    this.router.navigateByUrl('home');

  }
}