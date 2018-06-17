import {Component, OnInit} from '@angular/core';
import {CommentsService} from '../../services/commentsService';
import {Router} from '@angular/router';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {

  comments = [];

  constructor(private commService: CommentsService,
              private router: Router) {
    this.commService.getComments().subscribe(data => {
      this.comments = data;
    });
  }

  ngOnInit() {
  }

  refuse(id) {
    this.commService.refuseComment(id).subscribe(data => {
      location.reload();
    });
  }

  publish(id) {
    this.commService.publishComment(id).subscribe(data => {
      location.reload();
    });
  }

}
