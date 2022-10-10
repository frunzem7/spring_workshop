package com.example.spring_workshop.entites.dto;

import com.example.spring_workshop.entites.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String email;
    private String name;
    private String password;
    private String careerCoachEmail;
    private String streamName;
    private String streamId;

    public static EmployeeDTO employeeToEmployeeToDTO(Employee employee){
        return EmployeeDTO.builder()
                .email(employee.getEmail())
                .name(employee.getName())
                .password(employee.getPassword())
                .careerCoachEmail(employee.getCareerCoach().getEmail())
                .streamName(employee.getStream().getName())
                .build();
    }

    public Employee toEmployee(EmployeeDTO employeeDTO){
        return Employee.builder()
                .email(employeeDTO.getEmail())
                .name(employeeDTO.getName())
                .password(employeeDTO.getPassword())
                .build();
    }
}
