import { Component, OnInit } from '@angular/core';

// Définition de l'interface IItemObject
interface IItemObject {
  id: number;
  name: string;
}

@Component({
  selector: 'app-dragdrop',
  templateUrl: "./dragdrop.component.html",
  styleUrls: [ "./dragdrop.component.scss"
  ]
})
export class DragdropComponent implements OnInit {

  itemObjectsLeft: IItemObject[] = [
    { id: 1, name: 'Créer la classe User' },
    { id: 2, name: 'Créer la classe Task' },
    { id: 3, name: 'Créer l\'enum Status' },
  ];
  
  itemObjectsCenter: IItemObject[] = [
    { id: 1, name: 'Créer la classe User' },
    { id: 2, name: 'Créer la classe Task' },
    { id: 3, name: 'Créer l\'enum Status' },
  ];
 
  itemObjectsRight: IItemObject[] = [
    { id: 4, name: 'Powerpoint' },
    { id: 5, name: 'Création de la classe Project' },
    { id: 6, name: 'DTO' }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
