import { Component, OnInit } from '@angular/core';
import { Tarea } from '../model/tarea';
import { TareaService } from '../service/tarea.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-tarea',
  templateUrl: './create-tarea.component.html',
  styleUrls: ['./create-tarea.component.scss']
})
export class CreateTareaComponent implements OnInit {

  tarea: Tarea = new Tarea();
  submitted= false;

  constructor(private tareaservice: TareaService, private router: Router) { }

  ngOnInit() {
  }

  newTarea(): void {
    this.submitted = false;
    this.tarea = new Tarea();
  }
 
  save() {
    this.tareaservice.crearTarea(this.tarea)
      .subscribe(data => console.log(data), error => console.log(error));
    this.tarea = new Tarea();
  }
 
  onSubmit() {
    this.submitted = true;
    this.save();
  }
  volver(){
    this.router.navigate(['/listarTarea']);
  }
}


