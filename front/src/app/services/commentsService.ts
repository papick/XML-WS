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

  getComments(id): Observable<any> {
    return this.http.get(`http://localhost:8000/api/comments/get-comments-acc/${id}`, httpOptions);
  }

  addComment(comment): Observable<any> {
    return this.http.post('http://localhost:8000/api/comments/add-comment/',comment, httpOptions);
  }
}
