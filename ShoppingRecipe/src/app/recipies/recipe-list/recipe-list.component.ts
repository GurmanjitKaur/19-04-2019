import { Component, OnInit } from '@angular/core';
import {Recipe} from '../recipe.model';

@Component({
  selector: 'app-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  recipies: Recipe[] = [
    new Recipe('Recipe A','Recipe A description','https://pulses.org/images/com_yoorecipe/415/cropped-bandeja-paisa.jpg'),
    new Recipe('Recipe B','Recipe B description','https://www.washingtonian.com/wp-content/uploads/2018/01/pancakeBD-994x1100.jpg')
  ];
}
