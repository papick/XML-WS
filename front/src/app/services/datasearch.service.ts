import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class DataSearchService {
  private url = 'http://localhost:8000/api/';

  public data : any;

  constructor(private http:HttpClient) { }

  public getAllTypes(){
    return this.http.get(this.url + '/type-accommodation/get-types');
  }

  public getAllCategories(){
    return this.http.get(this.url+'/category/get-categories');
  }

  public getAllAdditions(){
    return this.http.get(this.url +'/additional-service/get-additional-services' );
  }
}
