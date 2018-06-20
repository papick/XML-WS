import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {LogInModel} from "../model/logIn.model";
import {Observable} from "rxjs/index";

//milica
const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class LogInService {

  private BASE_URL = 'http://localhost:8090/api/agent';

  constructor(private http: HttpClient) {
  }
  logIn(user: LogInModel): Observable<any> {
    const body = JSON.stringify(user);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put(`${this.BASE_URL}/log-in `, body, {headers: headers});
  }

}


