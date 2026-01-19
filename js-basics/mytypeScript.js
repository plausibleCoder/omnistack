console.log("Hello");
//Let 
var a = 20;
var sales = 123456789;
var course = "Typescript";
var is_published = true;
var level;
level = 2;
level = 'press';
//Any in Typescript
function render(document) {
    console.log(document);
}
//Arrays
var numbers = [1, 2]; //,'3']
numbers.forEach(function (n) {
    console.log("Hello, ".concat(n, "!"));
});
//Tuple
var user = [1, 'karthik'];
//We can use multiple as well. But that they dont represent anything, its better to have just 2 values
var userData = [1, "karthik", true, 9];
//Enums: List of related constants
var small = 1;
var medium = 2;
var large = 3;
var Size;
(function (Size) {
    Size["Small"] = "s";
    Size["Medium"] = "m";
    Size["Large"] = "l";
})(Size || (Size = {}));
;
var mySize = Size.Large;
console.log(mySize);
//Functions
function incomeCalculate(income, taxYear) {
    if (taxYear < 2022)
        return income * 1.2;
    return income * 1.3;
}
var employee = {
    id: 1,
    name: 'Mosh',
    retire: function (date) {
        console.log(date);
    }
};
//Union Types: With union type we can give 2 or more types to a variable
function kgToLbs(weight) {
    if (typeof weight == 'number')
        return weight * 2.2;
    else
        return parseInt(weight) * 2.2;
}
var textBox = {
    drag: function () { },
    resize: function () { }
};
var quant = 100;
//Nullable types
function greet(name) {
    if (name)
        console.log(name.toUpperCase());
    else
        console.log('Hola!');
}
greet(null);
