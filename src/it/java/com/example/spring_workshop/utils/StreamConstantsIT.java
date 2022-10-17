package com.example.spring_workshop.utils;

import com.example.spring_workshop.entites.Stream;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.example.spring_workshop.TestConstants.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StreamConstantsIT {

    public static final Stream STREAM_1 = Stream.builder()
            .id(ID_ONE)
            .department(DEPARTMENT_ONE)
            .name(STREAM_NAME_ONE)
            .mentor(null)
            .build();
}
