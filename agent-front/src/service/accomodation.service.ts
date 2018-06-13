import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/index";
import {AccomodationModel} from "../model/accomodation.model";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class AccomodationService {

  private BASE_URL = 'http://localhost:8090/api/accomodation';

  constructor(private http: HttpClient) {
  }

  getAccomodations(): Observable<any> {
    return this.http.get(`${this.BASE_URL}/all-accomodations`, httpOptions);
  }

  deleteAccomodation(id: any): Observable<any> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.delete(`${this.BASE_URL}/delete-accomodation/` + id, {headers: headers});
  }

  createAccomodation(accomodation: AccomodationModel, id: any): Observable<any> {
    const body = JSON.stringify(accomodation);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`${this.BASE_URL}/create/` + id, body, {headers: headers})
  }

}
