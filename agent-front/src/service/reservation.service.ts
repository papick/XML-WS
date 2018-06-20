import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/index";
import {ReservationModel} from "../model/reservation.model";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class ReservationService {

  private BASE_URL = 'http://localhost:8090/api/reservation';

  constructor(private http: HttpClient) {
  }

  createReservation(reservation: ReservationModel): Observable<any> {
    const body = JSON.stringify(reservation);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`${this.BASE_URL}/create-reservation `, body, {headers: headers});
  }

  getReservations(): Observable<any> {
    return this.http.get(`${this.BASE_URL}/all-reservations`, httpOptions);
  }


}


