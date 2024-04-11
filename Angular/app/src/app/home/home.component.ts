import { Component, OnInit } from '@angular/core';

type Timeout = ReturnType<typeof setInterval>;

@Component({
  selector: 'app-home',
  template: `
    <p [class]="counter % 2 === 0 ? 'even' : 'odd'">
      home works!
      {{ counter }}
    </p>
  `,
  styleUrls: [ "../app.component.scss" ]
})
export class HomeComponent implements OnInit {

  counter !: number;  // !: = jamais null ou undefined
  id ?: Timeout;      // ?: = peut être null ou undefined

  constructor() { }

  ngOnInit(): void {
    this.counter = 0;
  
    this.id = setInterval(() => {
      this.counter++;
      console.log("Expérience en cours");
    }, 1000);
  }

  ngOnDestroy(): void {
    clearInterval(this.id);
  }

}
