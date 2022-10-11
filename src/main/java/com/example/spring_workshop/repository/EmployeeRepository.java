package com.example.spring_workshop.repository;

import com.example.spring_workshop.entites.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    List<Employee> getAllByStreamDepartment(String department);

    @Query(value = "UPDATE employee set stream_id = :streamId where email = :email", nativeQuery = true)
    void addStreamToEmployee(Long streamId, String email);
}
