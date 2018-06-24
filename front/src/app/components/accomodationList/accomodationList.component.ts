import { Component, OnInit } from '@angular/core';
import {AccomodationService} from '../../services/accomodation.service'

@Component({
  selector: 'accomodation-list',
  templateUrl: './accomodationList.component.html',
  styleUrls: ['./accomodationList.component.css']
})
export class AccomodationListComponent implements OnInit {

  accomodations : any;
  fromDate : any;
  toDate : any;

  sortOptions : any;
  sortKey: string;
  sortField: string;
  sortOrder: number;

  constructor(private accomodationService:AccomodationService) { }

  ngOnInit() {

      this.accomodations =this.accomodationService.data;
      this.fromDate = this.accomodationService.fromDate;
      this.toDate = this.accomodationService.toDate
      this.accomodations.forEach((acc , index ,arr) =>{
        this.accomodationService.getPriceList(acc.id).subscribe(data => {
            let price:number=0;
            let d = new Date(this.fromDate.year, this.fromDate.month, this.fromDate.day);
            let to = new Date(this.toDate.year, this.toDate.month, this.toDate.day)
            while(d <= to){
              data.forEach((monthPrice , index , arr) =>{
                if(Number.parseInt (monthPrice.month) == d.getMonth()){

                  price +=  Number.parseInt (monthPrice.sum);
                }
              });
              d.setDate(d.getDate() + 1);
            }
            acc.price = price;

        });
      })


      this.sortOptions = [
            {label: 'Lowest Price', value: 'price'},
            {label: 'Highest Price', value: '!price'},
            {label: 'Lowest Category', value: 'category.id'},
            {label: 'Highest Category', value: '!category.id'},
            {label: 'Lowest Rating', value: 'rating'},
            {label: 'Highest Rating', value: '!rating'}
        ];

  }

  onSortChange(event) {
       let value = event.value;

       if (value.indexOf('!') === 0) {
           this.sortOrder = -1;
           this.sortField = value.substring(1, value.length);
       }
       else {
           this.sortOrder = 1;
           this.sortField = value;
       }
   }




}
