import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateTareaComponent } from './create-tarea/create-tarea.component';
import { ListTareaComponent } from './list-tarea/list-tarea.component';
import { ListLogComponent } from './list-log/list-log.component';
import { EditTareaComponent } from './edit-tarea/edit-tarea.component';

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
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
