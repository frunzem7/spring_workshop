package com.example.spring_workshop.controller;

import com.example.spring_workshop.entites.Employee;
import com.example.spring_workshop.entites.Stream;
import com.example.spring_workshop.utils.PrerequisitesIT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.example.spring_workshop.TestConstants.EMAIL_TWO;
import static com.example.spring_workshop.utils.EmployeeConstantsIT.EMPLOYEE_MENTOR_1;
import static com.example.spring_workshop.utils.StreamConstantsIT.STREAM_1;

//@ActiveProfiles("it")
@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIT {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    PrerequisitesIT prerequisitesIT;
    Stream stream;
    Employee employee;

    @BeforeEach
    public void setUp(){
        prerequisitesIT.clear();
        prerequisitesIT.createEmployee(EMPLOYEE_MENTOR_1);
        prerequisitesIT.createStream(STREAM_1);
        prerequisitesIT.addStreamToEmployee(8L,EMAIL_TWO );
    }

    @Test
    public void testSetup(){

    }
}
