package com.example.spring_workshop.controller;

import com.example.spring_workshop.entites.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static com.example.spring_workshop.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/db/test-data1.sql")
class EmployeeControllerIT {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void shouldReturnListOfAllEmployeesTest() {
        ResponseEntity<List<EmployeeDTO>> response = testRestTemplate.exchange(
                "http://localhost:" + port + "/employee",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<EmployeeDTO>>() {
                });
        assertFalse(response.getBody().isEmpty());
        assertEquals("b805544a-3ff3-42b2-8153-281a01ca0443", response.getBody().stream()
                .filter(employeeDTO -> employeeDTO.getUuid().equals("b805544a-3ff3-42b2-8153-281a01ca0443"))
                .findFirst()
                .map(EmployeeDTO::getUuid)
                .orElse(null));
    }

    @Test
    void shouldCreateEmployeeTest() {
        ResponseEntity<String> response = testRestTemplate.postForEntity(
                "http://localhost:" + port + "/employee",
                createEmployeeDTO(),
                String.class
        );
        assertThat(response).extracting(ResponseEntity::getStatusCode).isEqualTo(HttpStatus.CREATED);
    }

    public static EmployeeDTO createEmployeeDTO() {
        return EmployeeDTO.builder()
                .email(EMAIL_TWO)
                .name(NAME_TWO)
                .password(PASSWORD_TWO)
                .streamName("Java")
                .streamId("1")
                .build();
    }
}
