import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'}),
};

@Injectable()
export class AgentService {

  constructor(private http: HttpClient) {
  }

  getAgents(): Observable<any> {
    return this.http.get(`http://localhost:8000/api/agents/get-agents`, httpOptions);
  }

  addAgent(agent): Observable<any> {
    const body = JSON.stringify(agent);
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.post(`http://localhost:8000/api/agents/add-agent`, body, {headers: headers});
  }

  removeAgent(id): Observable<any> {
    return this.http.delete(`http://localhost:8000/api/agents/delete-agent/${id}`, httpOptions);
  }

}
