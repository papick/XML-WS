import {Component, OnInit} from '@angular/core';
import {AdditionalServiceService} from '../../services/additionalServiceService';
import {Router} from '@angular/router';

@Component({
  selector: 'app-additional-service',
  templateUrl: './additional-service.component.html',
  styleUrls: ['./additional-service.component.css']
})
export class AdditionalServiceComponent implements OnInit {

  additionalservices = [];

  constructor(private addServiceService: AdditionalServiceService,
              private router: Router) {
    this.addServiceService.getAdditionalServices().subscribe(data => {
      this.additionalservices = data;
    });
  }

  ngOnInit() {

  }

  add() {
    this.router.navigateByUrl('/home/additionalServiceForm/add');
  }

  edit(id) {
    this.router.navigateByUrl('/home/additionalServiceForm/edit/' + id);
  }

  removeAS(id) {
    this.addServiceService.removeAdditionalService(id).subscribe(data => {
        location.reload();
      }
    );
  }

}
