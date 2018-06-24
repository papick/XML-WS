import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/index";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class CommentService {

  private BASE_URL = 'http://localhost:8091/api/comment';

  constructor(private http: HttpClient) {
  }

  getComments(id: any): Observable<any> {
    return this.http.get(`${this.BASE_URL}//all-comment-for-accomodation/` + id, httpOptions);
  }
}
