import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { ButtonComponent } from './lib/button/button.component';
import { ModalComponent } from './lib/modal/modal.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DragdropComponent } from './dragdrop/dragdrop.component';
import { FormsModule } from '@angular/forms';
import { SortableModule } from 'ngx-bootstrap/sortable';
import { TaskComponent } from './task/task.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { MyhttpService } from 'myhttp.service';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { UpdateTaskComponent } from './update-task/update-task.component';
import { ProjectComponent } from './project/project.component';
import { UserComponent } from './user/user.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    ButtonComponent,
    ModalComponent,
    DragdropComponent,
    TaskComponent,
    LoginComponent,
    RegisterComponent,
    UpdateTaskComponent,
    ProjectComponent,
    UserComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    SortableModule.forRoot(),
    HttpClientModule,
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: MyhttpService,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }