import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {AdditionalServiceService} from '../../services/additionalServiceService';

@Component({
  selector: 'app-additional-service-form',
  templateUrl: './additional-service-form.component.html',
  styleUrls: ['./additional-service-form.component.css']
})
export class AdditionalServiceFormComponent implements OnInit {

  public form: FormGroup;
  public name: AbstractControl;

  additionalService = {
    name: ''
  };

  methodName = 'Dodaj';

  constructor(private fb: FormBuilder, protected route: ActivatedRoute,
              private additionalServiceService: AdditionalServiceService, private router: Router) {
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
      this.additionalServiceService.getAdditionalService(id).subscribe(data => {
        this.form.controls['name'].setValue(data.name);
      });
    } else if (method === 'add') {
      this.methodName = 'Dodaj';
    }
  }

  confirmClick() {
    if (this.methodName === 'Dodaj') {
      this.addAdditionalService();
    } else {
      this.editAdditionalService();
    }
  }

  addAdditionalService() {
    this.additionalService.name = this.name.value;

    this.additionalServiceService.addAdditionalService(this.additionalService).subscribe(data => {
        this.router.navigateByUrl('home/additionalService');
      }
    );
  }

  editAdditionalService() {
    const id = this.route.snapshot.params.id;
    this.additionalService.name = this.name.value;
    this.additionalServiceService.editAditionalService(this.additionalService, id).subscribe(data => {
      this.router.navigateByUrl('home/additionalService');
    });
  }

}
