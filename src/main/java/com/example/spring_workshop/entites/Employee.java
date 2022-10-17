package com.example.spring_workshop.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column(name = "employee_email", nullable = false)
    private String email;

    @Column(name = "employee_name", nullable = false)
    private String name;

    @Column(name = "employee_passwordl", nullable = false)
    private String password;

//    @OneToMany(mappedBy = "careerCoach")
//    @ToString.Exclude
//    private List<Employee> coachingEmployees;

//    @ManyToOne
//    @ToString.Exclude
//    private Employee careerCoach;

    @ManyToOne
    @ToString.Exclude
    private Stream stream;
}