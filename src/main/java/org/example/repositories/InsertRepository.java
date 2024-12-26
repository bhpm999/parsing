package org.example.repositories;

import org.example.domain.University;

import java.util.List;

public interface InsertRepository {
    void insertUniversities(List<University> universities);
    void insertAuthorisation();
    void insertFaculty(List<University> universities);
}
