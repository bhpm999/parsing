package org.example.services;

import org.example.domain.University;

import java.util.List;

public interface InsertServise {
    void insertAuthorisation();
    void insertUniversity(List<University> universities);
    void insertFaculty(List<University> universities);
}
