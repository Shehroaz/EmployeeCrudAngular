package com.sherry.employeeangularcrud.service;

import com.sherry.employeeangularcrud.dto.EmployeeDTO;
import com.sherry.employeeangularcrud.entity.Employee;
import com.sherry.employeeangularcrud.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CRUDService {
    private final EmployeeRepository employeeRepository;

    public CRUDService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
        return mapToEmployeeDTOFromEmployee(employeeRepository.save(mapToEmployeeFromEmployeeDTO(employeeDTO)));
    }

    public List<EmployeeDTO> getAllEmployeesList(){
        return employeeRepository.findAll().stream()
                .map(this::mapToEmployeeDTOFromEmployee)
                .collect(Collectors.toList());
    }

    private Employee mapToEmployeeFromEmployeeDTO(EmployeeDTO employee){
        Employee saveEmployee = new Employee();
        saveEmployee.setFirstName(employee.getFirstName());
        saveEmployee.setEmail(employee.getEmail());
        saveEmployee.setLastName(employee.getLastName());
        return saveEmployee;
    }

    private EmployeeDTO mapToEmployeeDTOFromEmployee(Employee employee){
        EmployeeDTO newEmployee = new EmployeeDTO();
        newEmployee.setId(employee.getId());
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setEmail(employee.getEmail());
        return newEmployee;
    }
}
