import { Employee } from './../model/employee';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private httpClient : HttpClient) {}

  private baseURL = "http://localhost:1001/angularCrud/api/v1/";

  getListOfEmployees() : Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(this.baseURL + "employees");
  }

  createEmployee(employee : Employee) : Observable<Object>{
    return this.httpClient.post(this.baseURL + "employee" , employee);
  }
}
