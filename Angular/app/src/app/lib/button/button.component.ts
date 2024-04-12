import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-button',
  template: `
    <span class=btn (click)="onClick()">{{ title }}</span>
    <div class="loader" *ngIf="loading"></div>
  `,
  styles: [`
    .btn {
      display: inline-block;
      border: solid 2px white;
      cursor: pointer;
      padding: 10px 15px;
      background-color: lightseagreen;
      color: white;
      text-transform: uppercase;
      font-weight: 600;
      transition: 0.3s ease-in-out;

      &:hover {
        background-color: lightslategray;
      }
    }

    .loader {
    margin-top: 40px;
    width: calc(6*30px);
    height: 50px;
    display: flex;
    color: coral;
    filter: drop-shadow(30px 25px 0 currentColor) drop-shadow(60px 0 0 currentColor) drop-shadow(120px 0 0 currentColor);
    clip-path: inset(0 100% 0 0);
    animation: l12 2s infinite steps(7);
    }
    .loader:before {
      content: "";
      width: 30px;
      height: 25px;
      --c:no-repeat radial-gradient(farthest-side,currentColor 92%,#0000);
      background: 
          var(--c) left /70% 70%,
          var(--c) right/20% 20%,
          var(--c) top    0 right 15%/20% 20%,
          var(--c) bottom 0 right 15%/20% 20%;
      }
      @keyframes l12 {
      100% {clip-path: inset(0 -30px 0 0)}
    }`
  ]
})
export class ButtonComponent implements OnInit {

  @Input() title : string = "";
  @Input() loading : boolean = false;
  @Output() onclick = new EventEmitter<void>()

  constructor() { }

  ngOnInit(): void {
  }

  onClick() : void {
    this.onclick.emit();
  }

}
