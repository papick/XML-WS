import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class TypeAccommodationService {

  constructor(private http: HttpClient) {
  }

  getTypes(): Observable<any> {
    return this.http.get(`http://localhost:8000/api/type-accommodation/get-types`, httpOptions);
  }

  addTypeAccomodation(type): Observable<any> {
    const body = JSON.stringify(type);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`http://localhost:8000/api/type-accommodation/add-type`, body, {headers: headers});
  }

  getType(id): Observable<any> {
    return this.http.get(`http://localhost:8000/api/type-accommodation/get-type/${id}`, httpOptions);
  }

  editType(type, id): Observable<any> {
    const body = JSON.stringify(type);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put(`http://localhost:8000/api/type-accommodation/edit-type/${id}`, body, {headers: headers});
  }

  removeTypeAccomodation(id): Observable<any> {
    return this.http.delete(`http://localhost:8000/api/type-accommodation/delete-type/${id}`, httpOptions);
  }
}
