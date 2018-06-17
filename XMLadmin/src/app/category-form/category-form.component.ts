import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {CategoryService} from '../../services/categoryService';

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.css']
})
export class CategoryFormComponent implements OnInit {

  public form: FormGroup;
  public name: AbstractControl;

  category = {
    name: ''
  };

  methodName = 'Dodaj';

  constructor(protected route: ActivatedRoute, private fb: FormBuilder,
              private categoryService: CategoryService,
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
      this.categoryService.getCategory(id).subscribe(data => {
        this.form.controls['name'].setValue(data.name);
      });
    } else if (method === 'add') {
      this.methodName = 'Dodaj';
    }
  }

  confirmClick() {
    if (this.methodName === 'Dodaj') {
      this.addCategory();
    } else {
      this.editCategory();
    }
  }

  addCategory(){
    this.category.name = this.name.value;

    this.categoryService.addCategory(this.category).subscribe(data => {
        this.router.navigateByUrl('home/category');
      }
    );
  }

  editCategory(){
    const id = this.route.snapshot.params.id;
    this.category.name = this.name.value;
    this.categoryService.editCategory(this.category, id).subscribe(data => {
      this.router.navigateByUrl('home/category');
    });
  }

}
