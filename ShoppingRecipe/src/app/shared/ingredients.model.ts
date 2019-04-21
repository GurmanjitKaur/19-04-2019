/* export class Ingredient {
    public name: string;
    public amount: number;

    constructor(name: string, amt: number) {
        this.name = name;
        this.amount = amt;
    }
} */

// Shorter way of same as above
export class Ingredient {
    constructor(public name: string, public amount: number) { }
}