package com.example.spring_workshop.utils;

import com.example.spring_workshop.entites.Employee;
import com.example.spring_workshop.entites.dto.EmployeeDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.example.spring_workshop.TestConstants.*;
import static com.example.spring_workshop.utils.StreamTestUtils.STREAM_ONE;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeTestUtils {

    public static final Employee EMPLOYEE_TWO = Employee.builder()
            .email(EMAIL_TWO)
            .name(NAME_TWO)
            .password(PASSWORD_TWO)
            .stream(STREAM_ONE)
            .build();
    public static final Employee EMPLOYEE_ONE = Employee.builder()
            .email(EMAIL_ONE)
            .name(NAME_ONE)
            .password(PASSWORD_ONE)
            .stream(STREAM_ONE)
            .careerCoach(EMPLOYEE_TWO)
            .build();
    public static final EmployeeDTO EMPLOYEE_DTO_ONE = EmployeeDTO.builder()
            .email(EMAIL_ONE)
            .name(NAME_ONE)
            .password(PASSWORD_ONE)
            .careerCoachEmail(EMPLOYEE_ONE.getCareerCoach().getEmail())
            .streamName(STREAM_ONE.getName())
            .build();
}