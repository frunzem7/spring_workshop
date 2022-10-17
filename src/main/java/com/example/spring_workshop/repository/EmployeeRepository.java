package com.example.spring_workshop.repository;

import com.example.spring_workshop.entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> getAllByStreamDepartment(String department);

    void deleteEmployeeByUuid(String uuid);

//    @Query(value = "UPDATE employee set stream_id = :streamId where uuid = :employeeUuid", nativeQuery = true)
//    void addStreamToEmployee(Long streamId, UUID employeeUuid);
}
