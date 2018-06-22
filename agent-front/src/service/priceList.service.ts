import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {PriceListModel} from "../model/priceList.model";
import {Observable} from "rxjs/index";

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class PriceListService {

  private BASE_URL = 'http://localhost:8090/api/price';

  constructor(private http: HttpClient) {
  }

  createPriceList(priceList: PriceListModel, id: any): Observable<any> {

    const body = JSON.stringify(priceList);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`${this.BASE_URL}/create-price-list/` + id, body, {headers: headers});
  }

}
