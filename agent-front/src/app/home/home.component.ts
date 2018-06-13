import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {AccomodationService} from "../../service/accomodation.service";

@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})

export class HomeComponent implements OnInit {
  items = []


  constructor(protected router: Router,
              private  accomodationService: AccomodationService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {

    this.accomodationService.getAccomodations().subscribe(data => {
      this.items = data.accomodations;


    })
  }


  addAccomodation() {
    this.router.navigateByUrl('add/accomodation')
  }

  editAccomodation(id): any  {
    this.router.navigateByUrl('edit/accomodation/' + id);
  }

  deleteAccomodation(id): any {
    this.accomodationService.deleteAccomodation(id).subscribe(data => {
        this.items = this.items.filter(el => el.id != id);

      })
  }
}
