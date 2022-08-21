package com.sherry.employeeangularcrud.controller;


import com.sherry.employeeangularcrud.dto.EmployeeDTO;
import com.sherry.employeeangularcrud.service.CRUDService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/angularCrud/api/v1")
public class CRUDController {
    private final CRUDService service;

    public CRUDController(CRUDService crudService) {
        this.service = crudService;
    }
    @PostMapping("/employee")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(service.createEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getListOfEmployees(){
        return new ResponseEntity<>(service.getAllEmployeesList(), HttpStatus.OK);
    }
}
