package org.example.controllers;

import org.example.domain.University;
import org.example.repositories.ParsingRepository;
import org.example.repositories.impl.ParsingRepositoryImpl;
import org.example.services.ParsingService;
import org.example.services.impl.ParsingServiceImpl;

import java.util.List;

public class ParsingController {
    private ParsingRepository parsingRepository = new ParsingRepositoryImpl();
}
