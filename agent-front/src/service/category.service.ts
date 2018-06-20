import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs/index";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class CategoryService {

  private BASE_URL = 'http://localhost:8090/api/category';

  constructor(private http: HttpClient) {
  }

  getCategories(): Observable<any> {
    return this.http.get(`${this.BASE_URL}/get-categories`, httpOptions);
  }
}
