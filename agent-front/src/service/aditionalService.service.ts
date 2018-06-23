import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/index";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class AditionalServiceService {

  private BASE_URL = 'http://localhost:809'+ localStorage.getItem('agentId') +'/api/aditional-service';

  constructor(private http: HttpClient) {
  }

  getAditionalServices(): Observable<any> {
    return this.http.get(`${this.BASE_URL}/all-aditional-services`, httpOptions);
  }
}
