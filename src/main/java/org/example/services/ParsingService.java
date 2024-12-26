package org.example.services;

import org.example.domain.University;

import java.util.List;

public interface ParsingService {
    List<University> findUniversity(String url);
    List<University> getFaculty(List<University> universities);
    List<University> getSpecialities(List<University> universities);
}
