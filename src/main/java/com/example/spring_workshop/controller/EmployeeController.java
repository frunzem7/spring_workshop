package com.example.spring_workshop.controller;

import com.example.spring_workshop.entites.dto.EmployeeDTO;
import com.example.spring_workshop.service.EmployeeService;
import lombok.RequiredArgsConstructor;
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

    @DeleteMapping("/{email}")
    public void deleteByEmail(@PathVariable String email){
        employeeService.delete(email);
    }

    @PostMapping()
    public EmployeeDTO createUser(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.createUser(employeeDTO);
    }
}
