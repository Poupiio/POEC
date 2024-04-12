import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-button',
  template: `
    <button type="button" class="btn btn-primary" (click)="onClick()">
      {{ title }}
    </button>
    <div class="loader" *ngIf="loading"></div>
  `,
  styleUrls: [
    "./button.component.scss"
  ]
})
export class ButtonComponent implements OnInit {

  @Input() title : string = "";
  @Input() loading : boolean = false;
  @Output() onclick = new EventEmitter<void>();

  constructor() { }

  ngOnInit(): void {
  }

  onClick() : void {
    this.onclick.emit();
  }

}
