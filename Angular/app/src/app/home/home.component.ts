import { Component, OnInit } from '@angular/core';

// type Timeout = ReturnType<setInterval>;

@Component({
  selector: 'app-home',
  template: `
    <p>
      home works!
      {{ counter }}
    </p>
  `,
  styleUrls: [ ]
})
export class HomeComponent implements OnInit {

  counter !: number;
  id: number | undefined;

  constructor() { }

  ngOnInit(): void {
    this.counter = 0;
  
    this.id = Number(setInterval(() => {
      this.counter++;
      console.log("Expérience en cours");
    }, 1000));
  }

  ngOnDestroy(): void {
    clearInterval(this.id);
  }

}
