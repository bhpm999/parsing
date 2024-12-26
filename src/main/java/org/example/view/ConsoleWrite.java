package org.example.view;

import org.example.controllers.ParsingController;
import org.example.domain.Faculty;
import org.example.domain.Speciality;
import org.example.domain.University;
import org.example.services.InsertServise;
import org.example.services.ParsingService;
import org.example.services.impl.InsertServiceImpl;
import org.example.services.impl.ParsingServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class ConsoleWrite {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        ParsingService parsingService = new ParsingServiceImpl();
        List<University> universities = parsingService.findUniversity("https://abiturient.by/universities");
        for(University university: universities){
            session.save(university);
            for(Faculty faculty: university.getFaculties()){
                faculty.setUniversity(university);
                session.save(faculty);
                for(Speciality speciality: faculty.getSpecialities()){
                    speciality.setFaculty(faculty);
                    session.save(speciality);
                }
            }
        }
        session.getTransaction().commit();
    }
}
