import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class AccomodationService {
  private url = 'http://localhost:8000/api/accomodations';
  constructor(private http:HttpClient) { }

  public getAllAccomodations(){
    return this.http.get(this.url);
  }

  public getAccomodation(id){
    return this.http.get(this.url+'/'+id);
  }
}
