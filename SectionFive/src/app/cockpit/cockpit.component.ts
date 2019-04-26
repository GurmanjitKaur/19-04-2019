import { Component, OnInit, EventEmitter, Output, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-cockpit',
  templateUrl: './cockpit.component.html',
  styleUrls: ['./cockpit.component.css']
})
export class CockpitComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  serverName : string;
  blueprintName: string; 
  @Output() onServerCreated= new EventEmitter<{serverNm:string,blueprintNm:string}>();  
  @Output() onBlueprintCreated = new EventEmitter<{serverNm:string,blueprintNm:string}>();

  @ViewChild('blueprintInputName') blueprintInputName : ElementRef

  onAddServer(input: HTMLInputElement){
    this.onServerCreated.emit({
      //using local reference and can be done using View Chlid also
      serverNm: input.value,
      //Using View Child and can be done using local reference also
      blueprintNm:this.blueprintInputName.nativeElement.value
      });
  }

  onAddBlueprint(input: HTMLInputElement){
    this.onBlueprintCreated.emit({
      //using local reference and can be done using View Chlid also
      serverNm: input.value,
      //Using View Child and can be done using local reference also
      blueprintNm:input.value
      });
  }
}
