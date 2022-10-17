package com.example.spring_workshop.entites.dto;

import com.example.spring_workshop.entites.Stream;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StreamDTO {

    private String uuid;
    private String department;
    private String name;
    private Long mentorId;

    public static StreamDTO toStreamDto(Stream stream){
        return StreamDTO.builder()
                .uuid(stream.getUuid())
                .department(stream.getDepartment())
                .name(stream.getName())
                .build();
    }

    public static Stream toStreamEntity(StreamDTO stream){
        return Stream.builder()
            .uuid(UUID.randomUUID().toString())
            .name(stream.getName())
            .department(stream.getDepartment())
            .build();
    }
}
