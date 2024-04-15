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

  

  constructor(private formBuilder : FormBuilder) { }

  public taskForm = this.formBuilder.group({
    title : "",
    description :"",
    status : "TODO",
    estimation : new Date(),
    project : 0,
  })

  submit() : void {
    console.log("Submit cliqué ouiiiii");
    
  }

  ngOnInit(): void {
    // console.log(this.taskStatus);
  }

}
