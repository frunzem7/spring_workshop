package com.example.spring_workshop.utils;

import com.example.spring_workshop.entites.Employee;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.example.spring_workshop.TestConstants.*;
import static com.example.spring_workshop.utils.StreamConstantsIT.STREAM_1;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeConstantsIT {

    public static final Employee EMPLOYEE_MENTOR_1 = Employee.builder()
            .email(EMAIL_TWO)
            .name(NAME_TWO)
            .password(PASSWORD_TWO)
            .stream(null)
            .build();

    public static final Employee EMPLOYEE_2 = Employee.builder()
            .email(EMAIL_ONE)
            .name(NAME_ONE)
            .password(PASSWORD_ONE)
            .stream(STREAM_1)
            .build();



}
