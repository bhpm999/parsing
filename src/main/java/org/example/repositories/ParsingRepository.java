package org.example.repositories;

import org.example.domain.University;

import java.util.List;

public interface ParsingRepository {
    List<University> getUniversity(String url);
    List<University> getFaculty(List<University> universities);
    List<University> getSpecialities(List<University> universities);
}
