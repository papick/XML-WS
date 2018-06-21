import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable()
export class ReservationService {
  private url = 'http://localhost:8000/api/reservations'
  constructor(private http:HttpClient) { }

  public reserve(reservation){
    return this.http.post(this.url , reservation);
  }

  public getReservationsByUser(){
    return this.http.get(this.url );
  }

  public deleteReservation(id){
    return this.http.delete(this.url+id );
  }
}
