import { Component, OnInit } from '@angular/core';
import { IItemObject, Task, TaskToDisplay, TaskStatus,
  } from "../../types";
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
      this.displayTasks();
    });

    // this.taskDataService.getTaskById(id: number) {

    // }
  }

  displayTasks(): void {
    // COLONNE A FAIRE
    this.todo = this.tasks
      .filter(task => task.status === TaskStatus.TODO)
      .map(task => ({ title: task.title, id: task.id  }));

    // COLONNE EN COURS
    this.ongoing = this.tasks
      .filter(task => task.status === TaskStatus.ONGOING)
      .map(task => ({ title: task.title, id: task.id }));

    // COLONNE TERMINÉ
    this.done = this.tasks
      .filter(task => task.status === TaskStatus.DONE)
      .map(task => ({ title: task.title, id: task.id }));
  
    console.log(this.todo, this.ongoing, this.done);
  }

  // async deleteTask(id: number) {
  //   console.log("côté component : " + id);

  
    
    // try {
    //   await this.taskDataService.deleteTask(id);
    //   // Mise à jour locale de la liste des tâches après suppression
    //   this.tasks = this.tasks.filter(task => task.id !== id);
    //   this.updateTaskLists();
    // } catch (error) {
    //   console.error("Une erreur s'est produite lors de la suppression de la tâche :", error);
    //   // Gérer l'erreur si nécessaire
    // }
  // }


  async deleteTask(id: number) {
    console.log("ID de la tâche dans la base de données : ", id);

    try {
      await this.taskDataService.deleteTask(id);

      // Mise à jour de la liste sans avoir à refresh la page
      this.tasks = this.tasks.filter(task => task.id !== id);
      this.displayTasks();
    } catch (error) {
      console.error("Une erreur s'est produite lors de la suppression de la tâche :", error);
    }
  }
}
