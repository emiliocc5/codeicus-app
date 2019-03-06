import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TareaService {

  private baseUrl = 'http://localhost:8080/codeicus/tareas';
 
  constructor(private http: HttpClient) { }

  createTarea(tarea: Object): Observable<Object> {
      return this.http.post(`${this.baseUrl}` + `/create`, tarea);
    }
  
  updateTarea(id: number, value: any): Observable<Object> {  //en algun momento revisar este 
      return this.http.put(`${this.baseUrl}/${id}`, value);
    }
   
  deleteTarea(id: number): Observable<any> {
      return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
    }
   
  getTareasList(): Observable<any> {
      return this.http.get(`${this.baseUrl}`);
    }

  getTareaDetail(id: number): Observable<any>{        //tambien revisar este metodo
    return this.http.get(`${this.baseUrl}/${id}`); 

  }
}
