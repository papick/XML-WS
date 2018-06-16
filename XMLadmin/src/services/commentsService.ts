import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class CommentsService {

  constructor(private http: HttpClient) {
  }

  getComments(): Observable<any> {
    return this.http.get(`http://localhost:8000/api/comments/get-comments`, httpOptions);
  }

  publishComment(id): Observable<any> {
    return this.http.put(`http://localhost:8000/api/comments/approve-comment/${id}`, httpOptions);
  }

  refuseComment(id): Observable<any> {
    return this.http.delete(`http://localhost:8000/api/comments/delete-comment/${id}`, httpOptions);
  }

}
