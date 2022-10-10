package com.example.spring_workshop.utils;

import com.example.spring_workshop.entites.Stream;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.example.spring_workshop.TestConstants.*;
import static com.example.spring_workshop.utils.EmployeeTestUtils.EMPLOYEE_ONE;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StreamTestUtils {

    public static final Stream STREAM_ONE = Stream.builder()
            .id(ID_ONE)
            .department(DEPARTMENT_ONE)
            .name(STREAM_NAME_ONE)
            .mentor(EMPLOYEE_ONE)
            .build();
}