package com.sherry.employeeangularcrud.repository;

import com.sherry.employeeangularcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Override
    Optional<Employee> findById(Long aLong);
}
