import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient, HttpParams } from '@angular/common/http';
import { User } from '../_models/user';

const apiUrl = environment.apiUrl;

@Injectable({
  providedIn: 'root'
})

export class ApiService {

  constructor(private http: HttpClient) {
  }

  public login(username: string, password: string) {
    const params = new HttpParams().set('username', username).set('password', password);
    return this.http.post<User>('${this.apiUrl}/login', params);
  }

  public register(username: string, password: string, email: string) {
    const params = new HttpParams().set('username', username)
      .set('password', password)
      .set('email', email);

    return this.http.post<User>('${this.apiUrl}/register', params);
  }

  public resetPassword(email: string) {
    const params = new HttpParams().set('email', email);
    return this.http.post('${this.apiUrl}/resetPassword', params);
  }

  public logout(username: string) {
    const params = new HttpParams().set('username', username);
    return this.http.post('${this.apiUrl}/logout', params);
  }

  public deleteUser(username: string) {
    const params = new HttpParams().set('username', username);
    return this.http.post('${this.apiUrl}/deleteUser', params);
  }
}

