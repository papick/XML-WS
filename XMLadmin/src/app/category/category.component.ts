import {Component, OnInit} from '@angular/core';
import {CategoryService} from '../../services/categoryService';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  categories = [];

  constructor(private cService: CategoryService) {
    this.cService.getCategories().subscribe(data => {
      this.categories = data;
    });
  }

  ngOnInit() {
  }

}
