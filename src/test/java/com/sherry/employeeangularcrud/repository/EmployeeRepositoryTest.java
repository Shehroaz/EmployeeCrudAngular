package com.sherry.employeeangularcrud.repository;

import com.sherry.employeeangularcrud.entity.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeeRepositoryTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRepositoryTest.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee(100L, "Test", "Test", "test@gmail.com");
        employeeRepository.save(employee);
        LOGGER.info("Saved Employee is {}", employee);
    }

    @AfterEach
    void tearDown() {
        employeeRepository.delete(employee);
        LOGGER.info("Deleted Employee is {}", employee);
    }

    @Test
    void findEmployeeByIdTest(){
        Optional<Employee> optionalEmployee = employeeRepository.findById(1L);
        assertThat(optionalEmployee.get().getEmail()).isEqualTo(employee.getEmail());
        assertThat(optionalEmployee.get().getFirstName()).isEqualTo(employee.getFirstName());
    }
}
