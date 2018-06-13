import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {
  }

  getActiveUsers(): Observable<any> {
    return this.http.get(`http://localhost:8000/api/users/get-active-users`, httpOptions);
  }

  getBlockedUsers(): Observable<any> {
    return this.http.get(`http://localhost:8000/api/users/get-blocked-users`, httpOptions);
  }

  remove(id): Observable<any> {
    return this.http.delete(`http://localhost:8000/api/users/delete-user/${id}`, httpOptions);
  }

  activateUser(id): Observable<any> {
    return this.http.put(`http://localhost:8000/api/users/activate-user/${id}`, httpOptions);
  }

  blockUser(id): Observable<any> {
    return this.http.put(`http://localhost:8000/api/users/block-user/${id}`, httpOptions);
  }
}
