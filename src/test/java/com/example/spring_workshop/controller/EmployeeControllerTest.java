package com.example.spring_workshop.controller;

import com.example.spring_workshop.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static com.example.spring_workshop.TestConstants.DEPARTMENT_ONE;
import static com.example.spring_workshop.utils.EmployeeTestUtils.EMPLOYEE_DTO_ONE;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest extends BaseController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    @WithMockUser
    void shouldReturnAllEmployees() throws Exception {
        when(employeeService.getAllEmployees())
                .thenReturn(Collections.singletonList(EMPLOYEE_DTO_ONE));

        mockMvc.perform(get("/employee"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(createExpectedBody(
                        Collections.singletonList(EMPLOYEE_DTO_ONE))));

        verify(employeeService).getAllEmployees();
    }

    @Test
    @WithMockUser
    void getEmployeeByDepartmentTest() throws Exception {
        when(employeeService.getEmployeeByDepartment(DEPARTMENT_ONE))
                .thenReturn(Collections.singletonList(EMPLOYEE_DTO_ONE));

        mockMvc.perform(get("/employee/department").param("department", DEPARTMENT_ONE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(createExpectedBody(
                        Collections.singletonList(EMPLOYEE_DTO_ONE))));

        verify(employeeService).getEmployeeByDepartment(DEPARTMENT_ONE);
    }
}