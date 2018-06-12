import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  additionalService = false;
  agents = false;
  category = false;
  comments = false;
  typeAccommodation = false;
  users = false;

  constructor(protected route: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit() {
    const click = this.route.snapshot.params.click;

    if (click === 'additionalService') {
      this.additionalService = true;
      this.agents = false;
      this.category = false;
      this.comments = false;
      this.typeAccommodation = false;
      this.users = false;
    } else if (click === 'agents') {
      this.additionalService = false;
      this.agents = true;
      this.category = false;
      this.comments = false;
      this.typeAccommodation = false;
      this.users = false;

    } else if (click === 'category') {
      this.additionalService = false;
      this.agents = false;
      this.category = true;
      this.comments = false;
      this.typeAccommodation = false;
      this.users = false;

    } else if (click === 'comments') {
      this.additionalService = false;
      this.agents = false;
      this.category = false;
      this.comments = true;
      this.typeAccommodation = false;
      this.users = false;

    } else if (click === 'typeAccommodation') {
      this.additionalService = false;
      this.agents = false;
      this.category = false;
      this.comments = false;
      this.typeAccommodation = true;
      this.users = false;

    } else if (click === 'users') {
      this.additionalService = false;
      this.agents = false;
      this.category = false;
      this.comments = false;
      this.typeAccommodation = false;
      this.users = true;

    }
  }

  user() {
    this.router.navigateByUrl('home/users');
    location.reload();
  }

  agent() {
    this.router.navigateByUrl('home/agents');
    location.reload();
  }

  typeAcc() {
    this.router.navigateByUrl('home/typeAccommodation');
    location.reload();
  }

  categorization() {
    this.router.navigateByUrl('home/category');
    location.reload();
  }

  additional() {
    this.router.navigateByUrl('home/additionalService');
    location.reload();
  }

  comm() {
    this.router.navigateByUrl('home/comments');
    location.reload();
  }

}
