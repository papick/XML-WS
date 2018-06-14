import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  accomodations : any[];

  constructor() { }

  ngOnInit() {
    this.accomodations = [
      {
        name : 'Stojin Vukašinović',
        image : 'https://pix6.agoda.net/hotelImages/115/1157073/1157073_16062412150044053329.jpg?s=1024x768',
        type : 'debeli gmaz',
        location : 'kamilina grba'

      },
      {
        name : 'Lavlja dlaka na kašmiru',
        image : 'https://pix6.agoda.net/hotelImages/115/1157073/1157073_16062412230044053765.jpg?s=1024x768',
        type : 'orašasti plodovi',
        location : 'muda od labuda'
      }
    ]
  }

  

}
