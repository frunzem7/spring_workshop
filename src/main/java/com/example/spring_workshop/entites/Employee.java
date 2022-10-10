package com.example.spring_workshop.entites;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    private String email;
    private String name;
    private String password;

    @OneToMany(mappedBy = "careerCoach")
    @ToString.Exclude
    private List<Employee> coachingEmployees;
    @ManyToOne
    @ToString.Exclude
    private Employee careerCoach;
    @ManyToOne
    @ToString.Exclude
    private Stream stream;
}