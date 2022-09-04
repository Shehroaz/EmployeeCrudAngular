import { Employee } from './../model/employee';
import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../service/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee: Employee = new Employee();
  constructor(private employeeService : EmployeeService,
    private router : Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }

  saveEmployee(){
    this.employeeService.createEmployee(this.employee).subscribe(data =>{
      console.log(data);
      this.goToEmployeeListComponent();
    }, 
    error => console.log(error));     
  }

  goToEmployeeListComponent(){
    this.router.navigate(['/employees']);
  }
}




