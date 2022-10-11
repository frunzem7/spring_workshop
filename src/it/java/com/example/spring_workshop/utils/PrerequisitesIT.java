package com.example.spring_workshop.utils;

import com.example.spring_workshop.entites.Employee;
import com.example.spring_workshop.entites.Stream;
import com.example.spring_workshop.repository.EmployeeRepository;
import com.example.spring_workshop.repository.StreamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PrerequisitesIT {
    private final EmployeeRepository employeeRepository;
    private final StreamRepository streamRepository;

    @Transactional
    public void clear() {
        employeeRepository.deleteAll();
        streamRepository.deleteAll();
    }

    @Transactional
    public Stream createStream(Stream stream) {
        return streamRepository.save(stream);
    }

    @Transactional
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    public void addStreamToEmployee(Long streamId,String email ){
//        var stream= streamRepository.getStreamById(streamId);
        employeeRepository.addStreamToEmployee(streamId, email);

    }
}
