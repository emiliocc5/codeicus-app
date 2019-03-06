import { Component, OnInit } from '@angular/core';
import { Tarea } from '../tarea';
import { TareaService } from '../tarea.service';

@Component({
  selector: 'app-create-tarea',
  templateUrl: './create-tarea.component.html',
  styleUrls: ['./create-tarea.component.scss']
})
export class CreateTareaComponent implements OnInit {

  tarea: Tarea = new Tarea();
  submitted= false;

  constructor(private tareaservice: TareaService) { }

  ngOnInit() {
  }

  newTarea(): void {
    this.submitted = false;
    this.tarea = new Tarea();
  }
 
  save() {
    this.tareaservice.createTarea(this.tarea)
      .subscribe(data => console.log(data), error => console.log(error));
    this.tarea = new Tarea();
  }
 
  onSubmit() {
    this.submitted = true;
    this.save();
  }
}

