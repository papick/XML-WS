import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/index";
import {AnswerModel} from "../model/answer.model";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class MessageService {

  private BASE_URL = 'http://localhost:809'+ localStorage.getItem('agentId') +'/api/message';

  constructor(private http: HttpClient) {
  }


  getMessages(): Observable<any> {
    return this.http.get(`${this.BASE_URL}/all-messages`, httpOptions);
  }

  createAnswer(answer: AnswerModel): Observable<any> {
    const body = JSON.stringify(answer);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`${this.BASE_URL}/answer`, body,{headers: headers})
  }

}


