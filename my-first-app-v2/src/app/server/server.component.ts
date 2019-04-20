import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-server',
  templateUrl: './server.component.html',
  styleUrls: ['./server.component.css']
})
export class ServerComponent {
  constructor() {
    this.serverStatus = Math.random() > .5 ? 'online' : 'offline';
  }
  serverStatus: string = 'online';

  getColor(){
    return (this.serverStatus == 'online') ? 'greenyellow' : 'mistyrose';
  }
}
