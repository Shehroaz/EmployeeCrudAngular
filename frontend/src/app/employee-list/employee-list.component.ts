import { Employee } from './../model/employee';
import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../service/employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employeeList: Employee[] = [];


  constructor(private employeeService : EmployeeService) { }

  ngOnInit(): void {
   this.getEmployees();
  }

  private getEmployees(){
    this.employeeService.getListOfEmployees().subscribe(data => {
      this.employeeList = data;
    });
  }

}
