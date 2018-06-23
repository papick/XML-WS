import {Component} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {MessageService} from "../../service/message.service";
import {AnswerModel} from "../../model/answer.model";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'message',
  templateUrl: './message.component.html',

})

export class MessageComponent {
  answer = false;
  empty = false;

  messages = [];
  username = '';
  idSender;
  idMessage;
  idTo;

  public form: FormGroup;
  public text: AbstractControl;

  constructor(protected route: ActivatedRoute,
              private router: Router,
              private messageService: MessageService,
              private fb: FormBuilder) {
    this.form = this.fb.group({
      'text': ['', Validators.compose([Validators.required])],

    })
    this.text = this.form.controls['text'];


  }

  ngOnInit() {

    this.empty = false;
    this.messageService.getMessages().subscribe(data => {
      this.messages = data;
      if (this.messages.length === 0) {
        this.empty = true;
      }
    })


  }

  answerMessage(idSender: any, username: any, idMessage: any) {
    this.idSender = '';
    this.idTo='';
    this.idMessage = '';
    this.answer = false;
    this.idTo=idSender;
    this.idMessage = idMessage;
    this.idSender += username;
    console.log(this.idSender)
    this.answer = true;
  }

  sendAnswer() {
    const username = this.route.snapshot.params.username;
    console.log(

    this.text.value

  )
    const answer = new AnswerModel(
      username,
      this.idTo,
      this.text.value,
      this.idMessage,
    );

    this.messageService.createAnswer(answer).subscribe(data => {
      const username = this.route.snapshot.params.username;
      this.router.navigateByUrl(username + '/messages');

    })
    this.router.navigateByUrl(username + '/messages')
    location.reload();
  }
}
