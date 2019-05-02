import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  uri = 'http://localhost:4000';

  constructor(private http: HttpClient) { }

  getApp() {
    return this.http.get('${this.uri}/app');
  }
}
