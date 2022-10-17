package com.example.spring_workshop.utils;

import com.example.spring_workshop.entites.Employee;
import com.example.spring_workshop.entites.dto.EmployeeDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.example.spring_workshop.TestConstants.EMAIL_TWO;
import static com.example.spring_workshop.TestConstants.EMPLOYEE_UUID_1;
import static com.example.spring_workshop.TestConstants.NAME_TWO;
import static com.example.spring_workshop.TestConstants.PASSWORD_TWO;
import static com.example.spring_workshop.TestConstants.STREAM_NAME_ONE;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeConstantsIT {

    public static final Employee EMPLOYEE_1 = Employee.builder()
        .uuid(EMPLOYEE_UUID_1)
        .email(EMAIL_TWO)
        .name(NAME_TWO)
        .password(PASSWORD_TWO)
        .stream(null)
        .build();

    public static EmployeeDTO getEmployeeDto() {
        return EmployeeDTO.builder()
            .email(EMAIL_TWO)
            .name(NAME_TWO)
            .password(PASSWORD_TWO)
            .streamName(STREAM_NAME_ONE)
            .streamId(StreamConstantsIT.STREAM_1.getId().toString())
            .build();
    }
}
