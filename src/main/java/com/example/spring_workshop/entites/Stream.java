package com.example.spring_workshop.entites;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stream {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String department;
    private String name;
    @OneToOne
    @ToString.Exclude
    private Employee mentor;
    @OneToMany(mappedBy = "stream")
    @ToString.Exclude
    private List<Employee> membersOfStream;
}