import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/index";
import {AnswerModel} from "../model/answer.model";
import {MessageModel} from "../model/message.model";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class MessageService {

  private BASE_URL = 'http://localhost:8000/api/message';

  constructor(private http: HttpClient) {
  }


  getMessages(): Observable<any> {
    return this.http.get(`${this.BASE_URL}/all-messages`, httpOptions);
  }

  createMessage(message: MessageModel): Observable<any> {
    const body = JSON.stringify(message);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`${this.BASE_URL}/new-message`, body, {headers: headers})
  }

}


