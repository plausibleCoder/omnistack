console.log("Hello");
//Let 
let a: number = 20;

let sales = 123_456_789;

let course ="Typescript";

let is_published = true;

let level

level=2
level ='press'

//Any in Typescript
function render(document : any){
    console.log(document);
} 
//Arrays
let numbers:number[] =[1,2];//,'3']

numbers.forEach(n => {

    console.log(`Hello, ${n}!`);
});

//Tuple
let user: [number, string] = [1,'karthik'];

//We can use multiple as well. But that they dont represent anything, its better to have just 2 values
let userData: [number, string, boolean, number]=[1,"karthik",true,9];

//Enums: List of related constants

const small =1
const medium =2
const large= 3


enum Size {Small='s', Medium='m', Large='l'};
let mySize: Size= Size.Large;
console.log(mySize);

//Functions

function incomeCalculate(income: number, taxYear?: number):number{
    if(taxYear<2022)
        return income *1.2;
    return income*1.3
}

//Objects
type Employee= {
    readonly id: number;
    name:string;
    retire : (date:Date) =>void
}

let employee: Employee ={
    id:1,
    name : 'Mosh',
    retire : (date:Date)=> {

        console.log(date);
    }
}

//Union Types: With union type we can give 2 or more types to a variable
function kgToLbs (weight : number | string){
    if(typeof weight=='number')
        return weight*2.2;
    else
        return parseInt(weight)*2.2;
}

//Intersection Type
type Draggable = {
    drag : () => void
}

type Resizable = {
    resize : () => void
}

type UIWidget = Draggable & Resizable;

let textBox :UIWidget ={
    drag: () =>{},
    resize:() => {} 
}

//Literal Types : Sometimes we want to limit the type of values we use literal types
type Quantity = 50 |100;
let quant: Quantity =100;


//Nullable types
function greet(name : string | undefined | null){
    if(name)
    console.log(name.toUpperCase());
else
    console.log('Hola!')
}

greet(null);
greet(undefined);
greet('check');

//Optional
type Customer = {
    birthday : Date
}

function getCustomer(id: number): Customer | null {
    return id===0? null : {birthday: new Date()};
}

let customer = getCustomer(0);
//Optional property access operator (?.)
console.log(customer?.birthday);
