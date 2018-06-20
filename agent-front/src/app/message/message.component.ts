import {Component} from "@angular/core";

@Component({
  selector: 'message',
  templateUrl: './message.component.html',

})

export class MessageComponent {
  answer = false;

  answerMessage() {
    this.answer = true;
  }
}
