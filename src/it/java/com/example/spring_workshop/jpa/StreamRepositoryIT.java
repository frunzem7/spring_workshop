package com.example.spring_workshop.jpa;

import com.example.spring_workshop.entites.Stream;
import com.example.spring_workshop.repository.StreamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = "/db/test-data2.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("it")
public class StreamRepositoryIT {
    @Autowired
    private StreamRepository streamRepository;

    @Test
    void shouldReturnStreamByIdTest() {
        Stream streamById = streamRepository.getStreamById(1L);
        assertEquals(1L, streamById.getId());
    }
}
