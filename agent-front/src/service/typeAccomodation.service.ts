import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/index";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class TypeAccomodationService {

  private BASE_URL = 'http://localhost:8090/api/type-accomodation';

  constructor(private http: HttpClient) {
  }

  getTypeAccomodations(): Observable<any> {
    return this.http.get(`${this.BASE_URL}/all-type-accomodations`, httpOptions);
  }
}
