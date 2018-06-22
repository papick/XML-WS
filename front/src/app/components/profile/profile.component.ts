import {Component, OnInit} from '@angular/core';
import {UserService} from '../../services/user.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ReservationService} from "../../services/reservation.service";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MessageModel} from "../../model/message.model";
import {MessageService} from "../../services/message.service";
import {VoteModel} from "../../model/vote.model";
import {VoteService} from "../../services/vote.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: any = {};
  updatingUser: any = {}
  displayDialog: boolean = false;
  activeReservations = [];
  realizedReservations = [];
  sendMessage = false;
  reservationShow = true;
  voteShow = false;
  accName;
  idAgent;
  idAccomodationForVore;

  public form: FormGroup;
  public text: AbstractControl;

  //public form1: FormGroup;
  public vote1: AbstractControl;

  constructor(private userService: UserService,
              private route: ActivatedRoute,
              private reservationService: ReservationService,
              private fb: FormBuilder,
              private messageService: MessageService,
              protected router: Router,
              private voteService: VoteService) {
    this.form = this.fb.group({
      'text': ['', Validators.compose([Validators.required])],

    })
    this.text = this.form.controls['text'];

    this.form = this.fb.group({
      'vote1': ['', Validators.compose([Validators.required])],

    })
    this.vote1 = this.form.controls['vote1'];

    const username = this.route.snapshot.params['username'];
    this.userService.getUser(username).subscribe(user => this.user = user, err => console.log(err));
  }

  ngOnInit() {

    this.sendMessage = false;
    this.reservationShow = true;
    this.vote = false;

    const username = this.route.snapshot.params.username;
    this.reservationService.getReservationsByUser(username).subscribe(data => {
      for (var i = 0; i < data.length; i++) {
        if (data[i].confirmed === true) {
          this.realizedReservations.push(data[i])
        } else {
          this.activeReservations.push(data[i])
        }
      }
    })

  }

  copyUser(target, source) {
    target.username = source.username;
    target.id = source.id;
    target.email = source.email;
    target.password = source.password;

  }

  showEdit() {
    this.copyUser(this.updatingUser, this.user);
    this.displayDialog = true;
  }

  save() {
    this.userService.updateUser(this.updatingUser).subscribe(data => {
      this.displayDialog = false;
      this.copyUser(this.user, this.updatingUser);

    });
  }

  sendMessageToAgent(idAgent: any, idUser: any, nameAccomodation: any) {
    this.sendMessage = true;
    this.reservationShow = false;
    this.voteShow = false;

    this.accName = nameAccomodation;
    this.idAgent = idAgent;
    this.text.setValue('');

    //location.reload();
  }


  confirmSendMessage() {
    const username = this.route.snapshot.params.username;

    const message = new MessageModel(
      username,
      this.idAgent,
      this.text.value,
    );

    this.messageService.createMessage(message).subscribe();

    this.sendMessage = false;
    this.reservationShow = true;
    this.voteShow = false;


  }

  exit() {
    this.sendMessage = false;
    this.reservationShow = true;
    this.voteShow = false;
  }

  showMessages() {
    const username = this.route.snapshot.params.username;
    this.router.navigateByUrl('profiles/' + username + '/messages')
  }

  cancleReservation(idReservation: any) {

    this.reservationService.deleteReservation(idReservation).subscribe(data => {

      this.activeReservations = this.activeReservations.filter(el => el.id != idReservation);
    })
  }

  voteForAccomodation(accomodationName: any, accomodationId: any) {
    this.sendMessage = false;
    this.reservationShow = false;
    this.voteShow = true;
    this.accName = accomodationName;
    this.idAccomodationForVore = accomodationId;
  }

  confirmVote() {

    const username = this.route.snapshot.params.username;

    const vote = new VoteModel(
      username,
      this.idAccomodationForVore,
      this.vote1.value,
    );
    console.log(this.vote1.value)
    this.voteService.createVote(vote).subscribe();

    this.sendMessage = false;
    this.reservationShow = true;
    this.voteShow = false;

  }

}
