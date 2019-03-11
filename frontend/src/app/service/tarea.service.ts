//Servicio para los metodos Http

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tarea } from '../model/tarea';

@Injectable({
  providedIn: 'root'
})
export class TareaService {

  //Meter todos los return dentro de un try {return} catch(error){}

  private baseUrl = 'http://localhost:8080/codeicus';
 
  constructor(private http: HttpClient) { }

  listarTareas(): Observable<any> {
    return this.http.get(`${this.baseUrl}`+`/listarTareas`);
  }

  detalleTarea(id: number): Observable<any>{        //tambien revisar este metodo
    return this.http.get(`${this.baseUrl}`+`/getTarea`+`/${id}`); }

  crearTarea(tarea: Tarea): Observable<Object> {
      return this.http.post(`${this.baseUrl}` + `/crearTarea`, tarea);
  }
  
  editarTarea(tarea: Tarea): Observable<Object> {  
    return this.http.put(`${this.baseUrl}`+`/modificarTarea`+`/${tarea.id}`,tarea);
  }
   
  borrarTarea(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}`+`/borrarTarea`+`/${id}`, { responseType: 'text' });
  }
   
  }

