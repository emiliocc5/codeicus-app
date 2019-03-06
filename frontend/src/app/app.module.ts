import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateTareaComponent } from './create-tarea/create-tarea.component';
import { ModifyTareaComponent } from './modify-tarea/modify-tarea.component';
import { DeleteTareaComponent } from './delete-tarea/delete-tarea.component';
import { ListTareaComponent } from './list-tarea/list-tarea.component';
import { DetailTareaComponent } from './detail-tarea/detail-tarea.component';
import { ListLogComponent } from './list-log/list-log.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateTareaComponent,
    ModifyTareaComponent,
    DeleteTareaComponent,
    ListTareaComponent,
    DetailTareaComponent,
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
