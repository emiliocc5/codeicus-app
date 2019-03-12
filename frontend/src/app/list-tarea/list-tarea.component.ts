import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import { Observable } from 'rxjs';
import {Tarea} from '../model/tarea'
import { TareaService } from '../service/tarea.service';

@Component({
  selector: 'app-list-tarea',
  templateUrl: './list-tarea.component.html',
  styleUrls: ['./list-tarea.component.scss']
})
export class ListTareaComponent implements OnInit {

  tareas: Observable<Tarea[]>;

  constructor(private router: Router,private tareaservice: TareaService ) { }

  ngOnInit() {
    this.listar();
  }

  listar(){
    this.tareas= this.tareaservice.listarTareas(); 
  }

  editarTarea(tarea: Tarea): void{
    window.localStorage.setItem("detalleTareaId", tarea.id.toString());
    this.router.navigate(['/editTarea'])
  }

  crearTarea(): void{
    this.router.navigate(['/crearTarea'])
  }

  borrar(id: number){
    if(window.confirm('Estas seguro de que queres borrar esta tarea?')){
      this.tareaservice.borrarTarea(id)
      .subscribe(data => {console.log(data);
      this.listar();
      },
      error => console.log(error));
  }
}
  volver(){
    this.router.navigate(['/']);
  }
  topFunction(){
    document.body.scrollTop = document.documentElement.scrollTop = 0;
  }
  
}
