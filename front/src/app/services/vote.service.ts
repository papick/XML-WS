import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {MessageModel} from "../model/message.model";
import {VoteModel} from "../model/vote.model";
import {Observable} from "rxjs/Observable";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class VoteService {

  private BASE_URL = 'http://localhost:8000/api/vote';

  constructor(private http: HttpClient) {
  }


  createVote(vote: VoteModel) {
    const body = JSON.stringify(vote);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`${this.BASE_URL}/new-vote`, body, {headers: headers})
  }

  getVOte(username: any, idAcc: any): Observable<any> {
    return this.http.get(`${this.BASE_URL}/get-vote/` + idAcc + '/' + username, httpOptions);
  }
}
