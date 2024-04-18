import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { DragdropComponent } from './dragdrop/dragdrop.component';
import { TaskComponent } from './task/task.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './auth.guard';
import { UpdateTaskComponent } from './update-task/update-task.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "about", component: AboutComponent, canActivate: [AuthGuard] },
  { path: "about/id", component: AboutComponent },
  { path: "dragdrop", component: DragdropComponent, canActivate: [AuthGuard] },
  { path: "task", component: TaskComponent, canActivate: [AuthGuard] },
  { path: "task/add", component: TaskComponent, canActivate: [AuthGuard] },
  { path: "task/update/:id", component: UpdateTaskComponent, canActivate: [AuthGuard] },
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
