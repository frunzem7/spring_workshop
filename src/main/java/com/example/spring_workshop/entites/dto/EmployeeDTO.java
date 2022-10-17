package com.example.spring_workshop.entites.dto;

import com.example.spring_workshop.entites.Employee;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private String uuid;
    private String email;
    private String name;
    private String password;
    private String careerCoachEmail;
    private String streamName;
    private String streamId;

    public static EmployeeDTO employeeToEmployeeToDTO(Employee employee){
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
            .uuid(employee.getUuid())
            .email(employee.getEmail())
            .name(employee.getName())
            .password(employee.getPassword())
            .build();

        if (employee.getStream() != null) {
            employeeDTO.builder()
                .streamName(employee.getStream().getName())
                .build();

            return employeeDTO;
        }
        return employeeDTO;
    }

    public Employee toEmployee(EmployeeDTO employeeDTO){
        return Employee.builder()
                .uuid(UUID.randomUUID().toString())
                .email(employeeDTO.getEmail())
                .name(employeeDTO.getName())
                .password(employeeDTO.getPassword())
                .build();
    }
}
