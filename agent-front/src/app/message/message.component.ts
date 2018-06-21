import {Component} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {MessageService} from "../../service/message.service";

@Component({
  selector: 'message',
  templateUrl: './message.component.html',

})

export class MessageComponent {
  answer = false;
  empty = false;

  messages = [];
  username='';
  idSender;

  constructor(protected route: ActivatedRoute,
              private router: Router,
              private messageService: MessageService,) {
  }

  ngOnInit() {

    this.empty = false;
    this.messageService.getMessages().subscribe(data => {
      this.messages = data;
    })

    if (this.messages.length === 0) {
      this.empty = true;
    }


  }

  answerMessage(idSender: any , username:any) {
    this.idSender = '';
    this.answer = false;
    this.idSender += username;
    console.log(this.idSender)
    this.answer = true;
  }
}
