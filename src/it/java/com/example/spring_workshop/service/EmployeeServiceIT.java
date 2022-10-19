package com.example.spring_workshop.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("it")
public class EmployeeServiceIT {
    @Autowired
    private EmployeeService employeeService;

    @Test
    void shouldThrowNotFoundExceptionWhenDeleteEmployeeById() {
        final String EMPLOYEE_WITH_UUID_NOT_FOUND = "Employee with UUID = %s not found";

        Exception actualException = assertThrows(IllegalArgumentException.class,
                () -> employeeService.deleteEmployeeById(252L));

        assertEquals(String.format(EMPLOYEE_WITH_UUID_NOT_FOUND, "252"), actualException.getMessage());
    }
}
