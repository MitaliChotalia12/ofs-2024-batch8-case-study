import { Employee } from "./employee.js";

import readline from 'readline-sync';

import * as fs from 'fs';

try{
    let employeeId = readline.questionInt("Enter Employee Id: ");
let employeeName = readline.question("Enter name: ");
let employeeSalary = readline.questionInt("Enter salary: ");

let display = readline.question("Display input y/n: ");
if(display.toLowerCase() == 'y'){
    console.log("Employee Id: "+employeeId);
    console.log("Employee Name: "+employeeName);
    console.log("Employee Salary: "+employeeSalary);
}

const employee = new Employee(employeeId, employeeName, employeeSalary);

const data = fs.readFileSync("file.json");
var empData = data.toString()

var arr = []
if(empData){
    arr = JSON.parse(empData)["employees"]
}
arr.push(employee)
console.log(JSON.stringify({"employees" : arr}))
fs.writeFile('file.json', JSON.stringify({"employees" : arr}), function(err){

});
console.log("Data Added")
}catch (error) {
console.error(error);
}