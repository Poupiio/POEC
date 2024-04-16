import { Component, OnInit } from '@angular/core';
import { IItemObject } from "../../types";
import { TaskDataService } from '../services/task-data.service';
import { Task } from '../../types';

@Component({
  selector: 'app-dragdrop',
  templateUrl: "./dragdrop.component.html",
  styleUrls: [ "./dragdrop.component.scss"
  ]
})
export class DragdropComponent implements OnInit {

  tasks : Task[] = [];

  todo: IItemObject[] = [
    { id: 1, title: 'Créer la classe User', description: "c'est la description", estimation: 2, projectId: 3 },
    // { id: 2, title: 'Créer la classe Task' },
    // { id: 3, title: 'Créer l\'enum Status' },
  ];

  ongoing: IItemObject[] = [
    // { id: 1, title: 'Créer la classe User' },
    // { id: 2, title: 'Créer la classe Task' },
    // { id: 3, title: 'Créer l\'enum Status' },
  ];
 
  done: IItemObject[] = [
    // { id: 4, title: 'Powerpoint' },
    // { id: 5, title: 'Création de la classe Project' },
    // { id: 6, title: 'DTO' }
  ];

  constructor(
    private taskDataService: TaskDataService
  ) { }

  ngOnInit(): void {
    this.tasks = this.taskDataService.getTasks();
  }

}
