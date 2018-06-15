import {Component, OnInit} from '@angular/core';
import {CategoryService} from '../../services/categoryService';
import {Router} from '@angular/router';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  categories = [];

  constructor(private cService: CategoryService,
              private router: Router, private categoryService: CategoryService) {
    this.cService.getCategories().subscribe(data => {
      this.categories = data;
    });
  }

  ngOnInit() {
  }

  add() {
    this.router.navigateByUrl('/home/categoryForm/add');
  }

  edit(id) {
    this.router.navigateByUrl('/home/categoryForm/edit/' + id);
  }

  remove(id) {
    this.categoryService.removeCategory(id).subscribe(data => {
        location.reload();
      }
    );

  }

}
