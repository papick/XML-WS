import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {CommentService} from "../../service/comment.service";

@Component({
  templateUrl: './comment.component.html',
})

export class CommentComponent implements OnInit {

  comments = [];

  constructor(protected route: ActivatedRoute,
              private router: Router,
              private commentService: CommentService) {
  }

  ngOnInit() {
    const idAcc = this.route.snapshot.params.id;
    this.commentService.getComments(idAcc).subscribe(data => {
      this.comments = data;
    })
  }

  exit() {
    const username = this.route.snapshot.params.username;
    this.router.navigateByUrl(username + '/home')
  }

}
