import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListTareaComponent } from './list-tarea/list-tarea.component';
import { EditTareaComponent } from './edit-tarea/edit-tarea.component';
import { CreateTareaComponent } from './create-tarea/create-tarea.component';
import { ListLogComponent } from './list-log/list-log.component';
import { AppComponent } from './app.component';

const routes: Routes = [
  {path: '', component:AppComponent},
  {path: 'listarTarea', component:ListTareaComponent },
  {path: 'crearTarea', component:CreateTareaComponent },
  {path: 'editTarea', component:EditTareaComponent },
  {path: 'listarLogs', component:ListLogComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
