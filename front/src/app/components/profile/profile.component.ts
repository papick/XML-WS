import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user:any = {};
  updatingUser:any={}
  displayDialog:boolean = false;

  constructor(private userService :UserService, private route: ActivatedRoute ){

      const username=this.route.snapshot.params['username'];
      this.userService.getUser(username).subscribe(user => this.user = user, err=> console.log(err));
  }
  ngOnInit() {
  }

  copyUser(target, source){
    target.username = source.username;
    target.id = source.id;
    target.email = source.email;
    target.password = source.password;

  }

  showEdit(){
    this.copyUser(this.updatingUser, this.user);
    this.displayDialog = true;
  }

  save(){
    this.userService.updateUser(this.updatingUser).subscribe(data => {
      this.displayDialog = false;
      this.copyUser(this.user, this.updatingUser);

    });
  }

}
