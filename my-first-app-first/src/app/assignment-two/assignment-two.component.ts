import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-assignment-two',
  templateUrl: './assignment-two.component.html',
  styleUrls: ['./assignment-two.component.css']
})
export class AssignmentTwoComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  oddButtonClick : boolean = false;
  message : string = '';
  messagesArray : String[] = [];

  displayDetails(){
    this.message = 'secret password = tuna ' + new Date(); 
    this.oddButtonClick = !this.oddButtonClick;
    this.messagesArray.push(this.message);
  }
}
