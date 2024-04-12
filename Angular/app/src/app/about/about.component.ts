import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about',
  template: `
    <div>
      <app-button (onclick)="onClickButton()" [loading]="loading" title="Coucou je suis le bouton de la page About" [loading]="false"></app-button>
      <app-modal [isOpen]="loading" (onClose)="onClickButton()">
        <h1>Modal</h1>
        <p>Il était une fois</p>
      </app-modal>
    </div>
  `,
  styles: []
})
export class AboutComponent implements OnInit {

  loading: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  onClickButton() {
    this.loading = !this.loading;
  }

}