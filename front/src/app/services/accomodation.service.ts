import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class AccomodationService {
  private url = 'http://localhost:8000/api/accomodations';

  public data : any;
  public fromDate: any;
  public toDate : any;

  constructor(private http:HttpClient) { }

  public getAllAccomodations(){
    return this.http.get(this.url);
  }

  public getAccomodation(id){
    return this.http.get(this.url+'/'+id);
  }

  public getAllAccomodationsBySearch(searchBody){
    return this.http.post(this.url +'/search' , searchBody);
  }

  public getAllAccomodationsByAdvancedSearch(searchBody){
    return this.http.post(this.url +'/advancedSearch' , searchBody);
  }

  public getPriceList(id){
      return this.http.get<any[]>(this.url +'/'+id+'/prices' );
  }
}
