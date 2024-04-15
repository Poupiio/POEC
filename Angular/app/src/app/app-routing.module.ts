import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { DragdropComponent } from './dragdrop/dragdrop.component';
import { TaskComponent } from './task/task.component';

const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "about", component: AboutComponent },
  { path: "about/id", component: AboutComponent },
  { path: "dragdrop", component: DragdropComponent },
  { path: "task", component: TaskComponent },
  { path: "task/add", component: TaskComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
