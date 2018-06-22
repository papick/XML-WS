import {Component, OnInit} from "@angular/core";
import {ActivatedRoute, Router} from "@angular/router";
import {AccomodationService} from "../../service/accomodation.service";

@Component({
  selector: 'accomodations',
  templateUrl: './accomodations.component.html',
})

export class AccomodationsComponent implements OnInit {
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

  addPriceList(id : any, name : string) {

    const username = this.route.snapshot.params.username;
    this.router.navigateByUrl(username + '/price-list/' + id + '/' + name);
  }


  addAccomodation() {
    const username = this.route.snapshot.params.username;
    this.router.navigateByUrl(username + '/add/accomodation')
  }

  editAccomodation(id): any {
    const username = this.route.snapshot.params.username;
    this.router.navigateByUrl(username + '/edit/accomodation/' + id);
  }

  deleteAccomodation(id): any {
    this.accomodationService.deleteAccomodation(id).subscribe(data => {
      this.items = this.items.filter(el => el.id != id);

    })
  }
}
