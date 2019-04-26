import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  serverElements = [{
      type:"Blueprint",
      serverName : "ser name",
      blueprintName: "blueprint name"
    }];   

    onServerAdd(serverData:{serverNm:string,blueprintNm:string}){
      this.serverElements.push({
        type:"Server",
        serverName : serverData.serverNm,
        blueprintName: serverData.blueprintNm
      })
    }
  
    onBlueprintAdd(blueprintData:{serverNm:string,blueprintNm:string}){
      this.serverElements.push({
        type:"Blueprint",
        serverName : blueprintData.serverNm,
        blueprintName: blueprintData.blueprintNm
      })
    }
}
