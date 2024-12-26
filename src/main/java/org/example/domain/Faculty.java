package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "faculties")
@Setter
@Getter
@ToString
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @OneToMany(mappedBy = "faculty")
    private Set<Speciality> specialities;
    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;
}
