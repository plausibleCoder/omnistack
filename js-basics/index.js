         //This is my first line used 
    //console.log('What is total reimbursemnet for Maternity?');
//Variables
    let firstName='Teja';
    firstName=22;
    console.log(firstName);

    const lastName='GOAT';
    //lastName='567';
    //console.log(lastName);

//Values or Primitive Types

 let personName='Teja'; //String literal
 let personAge ='32'; //Number literal
 let adult= true;//Boolean literal
 let married= undefined;
 let wifeName=null; //used to clear the values in memory


//Reference Type
//Object, Array, Function
let person= {
    pName: 'Teja',
    pAge:'32'
};

console.log(person);

//Dot Notation
person.pName='Software Muthyam';

//Bracket Notation
person["pName"]="Not needed";

console.log(person);


//Array
let roles = ['son','brother','employee','student'];
console.log(roles);

roles[4]="boyfriend";
console.log(roles);

//function 

function tfiFan(){
    console.log("Jai Balayya!!");
}

tfiFan();

function tfiFan(heroName){
    console.log("I love "+heroName);
}

tfiFan('MB');

function squareArea(length, breadth){
    return length*breadth;
}

console.log(squareArea(33,33));