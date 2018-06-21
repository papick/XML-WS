import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable()
export class UserService {
  private url = 'http://localhost:8000/api/'
  constructor(private http:HttpClient) { }

  public login(user){
    return this.http.post(this.url + 'login', user);
  }

  public register(user){
    return this.http.post(this.url + 'register', user);
  }

  public logout(){

    return this.http.post(this.url + 'logout',{} );
  }

  public getUser(username){
    return this.http.get(this.url+'users/'+username);
  }

  public updateUser(user){
    return this.http.put(this.url+'users/edit-user/'+user.id , user);
  }

  public getLoggedUser(){
    const userJSON = sessionStorage.getItem('user')
    if(userJSON){
      return JSON.parse(userJSON);
    }
    return null;
  }
}
