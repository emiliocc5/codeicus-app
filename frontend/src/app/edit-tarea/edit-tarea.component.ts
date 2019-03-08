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

  tarea: Tarea;
  editform: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router,private tareaservice: TareaService ){}

  ngOnInit() {
    let TareaId = window.localStorage.getItem("detalleTareaId");
    if(!TareaId) {
      alert("Invalid action.")
      this.router.navigate(['list-tarea']);
      return;
    }

  this.editform = this.formBuilder.group({
    id: [''],
    nombre: ['', Validators.required],
    detalle: ['', Validators.required],
    estado: ['', Validators.required],
    });
  this.tareaservice.detalleTarea(+TareaId)
    .subscribe( data => {
    this.editform.setValue(data.result);
  });
}

onSubmit() {
  this.tareaservice.editarTarea(this.editform.value)
    /*.pipe(first())
    .subscribe(
      data => {
        if(data.status === 200) {
          alert('Tarea actualizada.');
          this.router.navigate(['list-tarea']);
        }else {
          alert(data.message);
        }
      },
      error => {
        alert(error);
      });*/
}

}




