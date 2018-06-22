import {Component, OnInit} from "@angular/core";
import {MessageService} from "../../services/message.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  templateUrl: './messages.component.html',
})

export class MessagesComponent implements OnInit {

  answer = false;
  empty = false;

  messages = [];
  username = '';


  constructor(protected route: ActivatedRoute,
              private router: Router,
              private messageService: MessageService,) {


  }

  ngOnInit() {

    this.empty = false;
    const username = this.route.snapshot.params.username;
    this.messageService.getMessages(username).subscribe(data => {
      this.messages = data;
      if (this.messages.length === 0) {
        this.empty = true;
      }
    })


  }
}
