import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs/Observable";
import {ReservationModel} from "../model/reservation.model";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};


@Injectable()
export class ReservationService {
  private url = 'http://localhost:8000/api/reservations'

  constructor(private http: HttpClient) {
  }

  reserve(res: ReservationModel) {
    const body = JSON.stringify(res);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`${this.url}/new`, body, {headers: headers})
  }

 /* public reserve(reservation : ) {
    return this.http.post(this.url, reservation);
  }*/

  getReservationsByUser(username: any): Observable<any> {
    return this.http.get(`${this.url}/user/` + username, httpOptions);
  }

  public deleteReservation(id: any) {
    return this.http.delete(this.url + '/' + id);
  }

}
