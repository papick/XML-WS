import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/index";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class PeriodService {

  private BASE_URL = 'http://localhost:8091/api/period';

  constructor(private http: HttpClient) {
  }


  getPeriods(): Observable<any> {
    return this.http.get(`${this.BASE_URL}/all-periods`, httpOptions);
  }


}


