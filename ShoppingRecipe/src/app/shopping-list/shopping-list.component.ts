import { Component, OnInit } from '@angular/core';
import { Ingredient } from "../shared/ingredients.model"

@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.css']
})
export class ShoppingListComponent implements OnInit {

  constructor() { }
  ingredients: Ingredient[] = [
    new Ingredient("apples",5),
    new Ingredient("Mangoes",2)
  ];

  ngOnInit() {
  }

}
