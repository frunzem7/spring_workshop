package com.example.spring_workshop.controller;

import com.example.spring_workshop.entites.dto.EmployeeDTO;
import com.example.spring_workshop.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/department")
    public List<EmployeeDTO> getEmployeeByDepartment(@RequestParam(defaultValue = "") String department){
        return employeeService.getEmployeeByDepartment(department);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteByEmail(@PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.deleteEmployeeById(employeeId));
    }

    @PostMapping()
    public ResponseEntity<String> createUser(@RequestBody EmployeeDTO employeeDTO){
        return  ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employeeDTO));
    }
}
