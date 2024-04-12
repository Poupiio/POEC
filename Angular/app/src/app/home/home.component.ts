import { Component, OnInit } from '@angular/core';

type Timeout = ReturnType<typeof setInterval>;

@Component({
  selector: 'app-home',
  template: `
  <div>
    <p [class]="counter % 2 === 0 ? 'even' : 'odd'">
      home works!
      {{ counter }}
    </p>
    <app-button title="coucou" (click)="onClick()"></app-button>
  </div>
  `,
  styleUrls: [ "../app.component.scss" ]
})
export class HomeComponent implements OnInit {

  counter !: number;  // !: = jamais null ou undefined
  id ?: Timeout;      // ?: = peut être null ou undefined<w

  constructor() { }

  ngOnInit(): void {
    this.counter = 0;
  
    this.id = setInterval(() => {
      this.counter++;
    }, 1000);
  }

  ngOnDestroy(): void {
    clearInterval(this.id);
  }

  onClick() : void {
    alert("Coucou");
  }
}
