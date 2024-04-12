import { Component, OnInit, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-modal',
  template: `
    <div *ngIf="isOpen" class="overlay" (click)="onClose.emit()">
      <div class="modal" (click)="onClickModal($event)">
        <div class="close" (click)="onClose.emit()">&times;</div>
        <ng-content></ng-content>
      </div>
    </div>
  `,
  styles: [`
    .overlay {
      position: absolute;
      top: 0;
      left: 0;
      right: 0;
      bottom: 0;
      background-color: rgba(0,0,0,0.5);
      color: #060905;
    }
    .overlay .modal {
      margin: 15% auto;
      background-color: #fefefe;
      min-width: 300px;
      max-width: 80%;
      min-height: 200px;
      position: relative;
      padding: 10px 20px;
    }
    .close {
      display: flex;
      align-items: center;
      justify-content: center;
      position: absolute;
      top: 10px;
      right: 10px;
      color: #000;
      font-size: 30px;
      cursor: pointer;
      border: 2px solid black;
      border-radius: 50px;
      width: 20px;
      height: 20px;
      padding-top: 1px;
      user-select: none;
    }
    .close:hover {
      background-color: #777;
      color: white;
    }
  `]
})
export class ModalComponent implements OnInit {

  @Input() isOpen : boolean = true;
  @Output() onClose = new EventEmitter<void>();

  constructor() { }

  ngOnInit(): void {
  }

  onClickModal(e: MouseEvent) {
    e.stopPropagation();
  }

}
