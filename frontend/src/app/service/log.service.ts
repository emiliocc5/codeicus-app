import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LogService {

  private baseUrl = 'http://localhost:8080/codeicus/logs';
 
  constructor(private http: HttpClient) { }

  listarLogs(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
