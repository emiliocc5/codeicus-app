import { Component, OnInit, Inject } from '@angular/core';
import { Tarea } from '../model/tarea';
import { Router } from '@angular/router';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import { TareaService } from '../service/tarea.service';
import {first} from "rxjs/operators";

@Component({
  selector: 'app-edit-tarea',
  templateUrl: './edit-tarea.component.html',
  styleUrls: ['./edit-tarea.component.scss']
})
export class EditTareaComponent implements OnInit {

  tarea: Tarea=new Tarea();
  editForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router,private tareaservice: TareaService ){}

  ngOnInit() {
    let TareaId = window.localStorage.getItem("detalleTareaId");
    if(!TareaId) {
      alert("No existe esa tarea, se lo redirigira al listado de tareas")
      this.router.navigate(['/listarTarea']);
      return;
    }
    this.editForm = this.formBuilder.group({
    id: [''],
    nombre: ['', Validators.required],
    detalle: ['', Validators.required],
    estado: ['', Validators.required],
    });
    this.tareaservice.detalleTarea(+TareaId)
      .subscribe( data => {
    this.editForm.setValue(data);
  });
}

onSubmit() {
  this.tareaservice.editarTarea(this.editForm.value)
    .pipe(first())
      .subscribe(
          data => {
            console.log(data);
            alert('Tarea modificada'); 
            this.router.navigate(['/listarTarea']);
          },
          error => {
            alert('Se produjo un error al modificar la tarea');
            console.log(error)});
        
}

ngOnDestroy(){  //Sin esto, al llamarlo por la URL directamente me trae el ultimo editado.
  window.localStorage.removeItem("detalleTareaId");
}
volver(){
  this.router.navigate(['/listarTarea']);
}
}




