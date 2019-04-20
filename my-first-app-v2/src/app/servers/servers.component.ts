import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {

  constructor() { 
    setTimeout(() => {
      this.isServerDisabled = false;
    }, 2000);
    
   }

  ngOnInit() {
  }

  isServerDisabled: boolean = true;  
  serverName: string = '';
  msgToDisplay: string = '';
 

  changeText(){
    this.msgToDisplay = 'Server is created and the name is '+this.serverName;
  }  

  onUpdateserverName(event: Event){
    console.log(event)
    this.serverName = (<HTMLInputElement>event.target).value;
  }

}
