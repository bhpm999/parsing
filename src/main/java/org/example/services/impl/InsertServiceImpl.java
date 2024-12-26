package org.example.services.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.domain.University;
import org.example.repositories.InsertRepository;
import org.example.repositories.impl.InsertRepositoryImpl;
import org.example.services.InsertServise;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;
import java.util.List;

@RequiredArgsConstructor
public class InsertServiceImpl implements InsertServise {
    @NonNull
    private WebDriver driver;
    private InsertRepository insertRepository = new InsertRepositoryImpl(driver);
    public void insertAuthorisation(){
        insertRepository.insertAuthorisation();
    }
    public void insertUniversity(List<University> universities){
        insertRepository.insertUniversities(universities);
    }
    public void insertFaculty(List<University> universities){
        insertRepository.insertFaculty(universities);
    }
}
