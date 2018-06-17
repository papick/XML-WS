import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class CategoryService {

  constructor(private http: HttpClient) {
  }

  getCategories(): Observable<any> {
    return this.http.get(`http://localhost:8000/api/category/get-categories`, httpOptions);
  }

  getCategory(id): Observable<any> {
    return this.http.get(`http://localhost:8000/api/category/get-category/${id}`, httpOptions);
  }

  addCategory(category): Observable<any> {
    const body = JSON.stringify(category);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`http://localhost:8000/api/category/add-category`, body, {headers: headers});
  }

  removeCategory(id): Observable<any> {
    return this.http.delete(`http://localhost:8000/api/category/delete-category/${id}`, httpOptions);
  }

  editCategory(category, id): Observable<any> {
    const body = JSON.stringify(category);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put(`http://localhost:8000/api/category/edit-category/${id}`, body, {headers: headers});
  }
}
