package com.example.spring_workshop.service;

import com.example.spring_workshop.entites.dto.EmployeeDTO;
import com.example.spring_workshop.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static com.example.spring_workshop.utils.EmployeeTestUtils.EMPLOYEE_DTO_ONE;
import static com.example.spring_workshop.utils.EmployeeTestUtils.EMPLOYEE_ONE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private StreamService streamService;

    @InjectMocks
    EmployeeService employeeService;

    @Test
    void shouldReturnAllEmployee() {
        //given
        final List<EmployeeDTO> expectedList = Collections.singletonList(EMPLOYEE_DTO_ONE);

        when(employeeRepository.findAll()).thenReturn(Collections.singletonList(EMPLOYEE_ONE));

        List<EmployeeDTO> actualList = employeeService.getAllEmployees();

        //then
        assertEquals(expectedList, actualList);
    }

//    @Test
//    @DisplayName("Should throw RecordNotFoundException")
//    @Disabled("Changed implementation - Needs refactor")
//    void shouldThrowRecordNotFoundException() {
//        when(employeeRepository.findById(EMAIL_ONE)).thenReturn(Optional.empty());
//        assertThrows(NullPointerException.class, () -> employeeService.getAllEmployees(EMPLOYEE_ONE));
//    }
}
