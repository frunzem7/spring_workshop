package com.example.spring_workshop.service;

import com.example.spring_workshop.entites.Employee;
import com.example.spring_workshop.entites.Stream;
import com.example.spring_workshop.entites.dto.EmployeeDTO;
import com.example.spring_workshop.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    private final StreamService streamService;

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeDTO::employeeToEmployeeToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<EmployeeDTO> getEmployeeByDepartment(String department) {
        return employeeRepository.getAllByStreamDepartment(department)
                .stream()
                .map(EmployeeDTO::employeeToEmployeeToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public String deleteEmployeeById(Long employeeId) {
        try {
            employeeRepository.deleteById(employeeId);
        } catch (Exception e){
            throw new IllegalArgumentException("Employee with UUID = " + employeeId + " not found");
        }
        return "Employee with UUID = " + employeeId + " was deleted successfully";
    }

    @Transactional
    public String createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeDTO.toEmployee(employeeDTO);
        Stream stream = streamService.getStreamById(employeeDTO.getStreamId());
        employee.setStream(stream);

        return employeeRepository.save(employee).getUuid();
    }
}
