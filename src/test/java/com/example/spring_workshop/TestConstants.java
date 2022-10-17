package com.example.spring_workshop;

import java.util.UUID;

public class TestConstants {
    public static final String EMAIL_ONE = "mariana.trofin@endava.com";
    public static final String NAME_ONE = "Mariana Trofin";
    public static final String PASSWORD_ONE = "1234";
    public static final Long ID_ONE = 1L;
    public static final String DEPARTMENT_ONE = "AM";
    public static final String STREAM_NAME_ONE = "JAVA";
    public static final String EMAIL_TWO = "elina.turcanu@endava.com";
    public static final String NAME_TWO = "Elina Turcanu";
    public static final String PASSWORD_TWO = "1111";

    public static final String EMPLOYEE_UUID_1 = UUID.randomUUID().toString();
    public static final String DELETE_EMPLOYEE_SUCCESS_MESSAGE = "Employee with UUID = " + EMPLOYEE_UUID_1 + " was "
                                                                 + "deleted successfully";
}
