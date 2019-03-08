import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateTareaComponent } from './create-tarea/create-tarea.component';
import { ListTareaComponent } from './list-tarea/list-tarea.component';
import { ListLogComponent } from './list-log/list-log.component';
import { EditTareaComponent } from './edit-tarea/edit-tarea.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CreateTareaComponent,
    EditTareaComponent,
    ListTareaComponent,
    ListLogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]  //Marca el punto de inicio de la aplicacion
})
export class AppModule { }
