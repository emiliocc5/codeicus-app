import { Component, OnInit } from '@angular/core';
import { Tarea } from '../model/tarea';
import { TareaService } from '../service/tarea.service';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-create-tarea',
  templateUrl: './create-tarea.component.html',
  styleUrls: ['./create-tarea.component.scss']
})
export class CreateTareaComponent implements OnInit {

  tarea: Tarea = new Tarea();
  createForm: FormGroup;
  submitted= false;

  constructor(private formBuilder: FormBuilder,private tareaservice: TareaService, private router: Router) { }

  ngOnInit(){ 
    this.createForm = this.formBuilder.group({
    id: [''],
    nombre: ['', Validators.required],
    detalle: ['', Validators.required],
    estado: ['', Validators.required],
    })
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
    this.tareaservice.crearTarea(this.tarea);
  }
  volver(){
    this.router.navigate(['/listarTarea']);
  }
}


