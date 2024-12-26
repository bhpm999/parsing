package org.example.services.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.domain.University;
import org.example.repositories.ParsingRepository;
import org.example.repositories.impl.ParsingRepositoryImpl;
import org.example.services.ParsingService;

import java.util.List;


public class ParsingServiceImpl implements ParsingService {
    ParsingRepository parsingRepository = new ParsingRepositoryImpl();
    @Override
    public List<University> findUniversity(String url) {
        return parsingRepository.getUniversity(url);
    }

    @Override
    public List<University> getFaculty(List<University> universities) {
        return  parsingRepository.getFaculty(universities);
    }

    @Override
    public List<University> getSpecialities(List<University> universities) {
        return parsingRepository.getSpecialities(universities);
    }

}
