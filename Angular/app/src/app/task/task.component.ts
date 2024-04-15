import { Component, OnInit } from '@angular/core';
import { TaskStatus } from "../../types";
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-task',
  templateUrl: "./task.component.html",
  styleUrls: [ "./task.component.scss"
  ]
})
export class TaskComponent implements OnInit {
  title : string = "";
  description : string ="";
  status : string = "TODO";
  estimation : number = 1;
  projectId : number = 1;
  

  // constructor(private formBuilder : FormBuilder) { }
  constructor() { }

  // public taskForm = this.formBuilder.group({
  //   title : "",
  //   description : "",
  //   status : "TODO",
  //   estimation : "1",
  //   project : 1,
  // })

  // submit() : void {
  //   console.log("Submit cliqué ouiiiii");
  //   const title = this.taskForm.value.title;
  //   const description = this.taskForm.value.description;
  //   const status = this.taskForm.value.status;
  //   const estimation = this.taskForm.value.estimation;
  //   const project = this.taskForm.value.project;

  //   console.log(title, description, status, estimation, project);

  //   // Réinitialisation des inputs du formulaire après la soumission
  //   this.taskForm.patchValue({
  //     title: '',
  //     description: '',
  //     status: 'TODO',
  //     estimation: '1',
  //     project: 1
  //   });
  // }

  submit() : void {
    console.log(this.title, this.description, this.status, this.estimation, this.projectId);

    this.title = "";
    this.description = "";
    this.status = "TODO";
    this.estimation = 1;
    this.projectId = 1;
  }

  ngOnInit(): void {}

}
