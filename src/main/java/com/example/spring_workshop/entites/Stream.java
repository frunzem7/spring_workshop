package com.example.spring_workshop.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Stream {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column(name = "streame_name", nullable = false)
    private String name;

    @Column(name = "department_name", nullable = false)
    private String department;

    @OneToOne
    @ToString.Exclude
    private Employee mentor;

    @OneToMany(mappedBy = "stream")
    @ToString.Exclude
    private List<Employee> membersOfStream;
}