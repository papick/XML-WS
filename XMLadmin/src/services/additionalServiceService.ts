import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class AdditionalServiceService {

  constructor(private http: HttpClient) {
  }

  getAdditionalServices(): Observable<any> {
    return this.http.get(`http://localhost:8000/api/additional-service/get-additional-services`, httpOptions);
  }

  getAdditionalService(id): Observable<any> {
    return this.http.get(`http://localhost:8000/api/additional-service/get-additional-service/${id}`, httpOptions);
  }

  addAdditionalService(as): Observable<any> {
    const body = JSON.stringify(as);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`http://localhost:8000/api/additional-service/add-additional-service`, body, {headers: headers});
  }

  removeAdditionalService(id): Observable<any> {
    return this.http.delete(`http://localhost:8000/api/additional-service/delete-additional-service/${id}`, httpOptions);
  }

  editAditionalService(as, id): Observable<any> {

    const body = JSON.stringify(as);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put(`http://localhost:8000/api/additional-service/edit-additional-service/${id}`, body, {headers: headers});
  }
}
