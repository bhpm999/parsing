package org.example.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "universities")
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String town;
    @OneToMany(mappedBy = "university")
    private List<Faculty> faculties;
}
