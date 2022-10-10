package com.example.spring_workshop.entites.dto;

import com.example.spring_workshop.entites.Stream;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StreamDTO {
    private Long id;
    private String department;
    private String name;
    private String mentorEmail;

    public static StreamDTO toDTO(Stream stream){
        return StreamDTO.builder()
                .id(stream.getId())
                .department(stream.getDepartment())
                .name(stream.getName())
                .mentorEmail(stream.getMentor().getEmail())
                .build();
    }
}
