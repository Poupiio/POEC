import { Component, OnInit } from '@angular/core';
import { IItemObject, Task, TaskToDisplay, TaskStatus  } from "../../types";
import { TaskDataService } from '../services/task-data.service';

@Component({
  selector: 'app-dragdrop',
  templateUrl: "./dragdrop.component.html",
  styleUrls: [ "./dragdrop.component.scss"
  ]
})
export class DragdropComponent implements OnInit {

  tasks: Task[] = [];
  todo: TaskToDisplay[] = [];
  ongoing: TaskToDisplay[] = [];
  done: TaskToDisplay[] = [];

  constructor(private taskDataService: TaskDataService) { }

  ngOnInit(): void {
    // Je récupère les tâches depuis la BDD
    this.taskDataService.getTasks().subscribe(res => {
      this.tasks = res;

      // Puis je les dispatche dans les colonnes correspondant au statut de la tâche
      this.updateTaskLists();
    });
  }

  updateTaskLists(): void {
    this.todo = this.tasks
      .filter(task => task.status === TaskStatus.TODO)
      .map(task => ({ title: task.title }));
    this.ongoing = this.tasks
      .filter(task => task.status === TaskStatus.ONGOING)
      .map(task => ({ title: task.title }));
    this.done = this.tasks
      .filter(task => task.status === TaskStatus.DONE)
      .map(task => ({ title: task.title }));
  }

}
