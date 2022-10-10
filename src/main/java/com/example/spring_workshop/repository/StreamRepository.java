package com.example.spring_workshop.repository;

import com.example.spring_workshop.entites.Stream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StreamRepository extends JpaRepository<Stream, Long> {
    List<Stream> getAllByDepartment(String department);

    Stream getStreamByName (String streamName);

    Stream getStreamById(Long streamId);
}
