//Funtional Programming
let legnth = 30_000;
let breadth = 2;

function area(legnth, breadth){
return legnth*breadth;
}

console.log(area(legnth,breadth));

//OOPS program

let CalculateArea = {

 legnth  :30_000,
 breadth : 20,

getArea: function(){
return this.legnth* this.breadth;
}

}
console.log(CalculateArea.getArea());

//Lets learn to create a class
const Student = {
    age: 23,
    studentName:"Karthik",
    subjects :{
        math:98,
        social:56,
    },
    attendence : [
        {year:2025, percentage:"75%"},
        {year:2024, percentage:"77%"},
        {year:2023, percentage:"83%"}
    ],
    score: function (){
        let total=0;
       let count=0; 
        for(let entry in this.subjects){
            total+=this.subjects[entry];
            count++;
        }
       const average = total / count;
       if(average>35){
            return "Hi " + this.studentName + ", your average score is " + average +" and you have Passed";
       }
       else{
             return "Hi " + this.studentName + ", your average score is " + average +" and you have Failed";
       }
        
        
    }

};

console.log(Student.score());
console.log(Student.subjects.math);

//CAB******************
//bind in Objects
/*
What is bind?
1. Bind an object to a funtion
2. Reference it using 'this'
*/
let c1 = {
 x:5,
 y:10
};

let c2 = {
    x:75, 
    y:235
};

function printCoordinates(){
   // console.log(this.x + ', '+this.y);
   console.log(this);
}

printCoordinates(); /* In your code, printCoordinates() displays undefined, undefined because of how the execution context works in JavaScript. 
The Reason
When you call printCoordinates() as a standalone function, its this keyword refers to the global object (the window object in browsers or global in Node.js). 
Since the global object does not have properties named x or y, this.x and this.y return undefined. Even though you defined c1 and c2, the function has no internal link to those objects unless you explicitly provide one. 
How to Fix It
To make the function use the coordinates from your objects, you must explicitly bind this to the object using call, apply, or bind
*/
let c1_func = printCoordinates.bind(c1);
let c2_func = printCoordinates.bind(c2);
c1_func();
c2_func();

//Call nethod
console.log('*********call method**************')
printCoordinates.call(c1);
printCoordinates.call(c2 + 'in the call method');

//Apply 

console.log('**************Apply method*************')
printCoordinates.apply(c1);


console.log('A common mnemonic is A for Apply (Array) and C for Call (Comma-separated).')