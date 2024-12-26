package org.example.repositories.impl;

import org.example.domain.Faculty;
import org.example.domain.Speciality;
import org.example.domain.University;
import org.example.repositories.ParsingRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



import java.io.IOException;
import java.util.*;

public class ParsingRepositoryImpl implements ParsingRepository {
    private String mainURL;
    @Override
    public List<University> getUniversity(String url) {
        List<University> universities = new ArrayList<>();
        try {
            Document universitiesPage =  Jsoup.connect(url).get();
            Elements universitiesNames =  universitiesPage.select(".views-field.views-field-title");
            for(Element element: universitiesNames) {
                if (element.selectFirst("a") != null) {
                    University university = new University();
                    List<Faculty> _faculties = new ArrayList<>();
                    university.setName(element.text());


                    Element univLinkElem = element.selectFirst("a");
                    String univInfoLink = null;
                    if (univLinkElem != null) {
                        univInfoLink = univLinkElem.absUrl("href");
                    }


                    if (univInfoLink != null) {
                        Document universityPage = Jsoup.connect(univInfoLink).get();
                        Elements faculties = universityPage.select(".view-univfaclist .views-field.views-field-title a");

                        for (Element faculty : faculties) {
                            if (faculty != null ) {
                                Faculty faculty1 = new Faculty();
                                Set<Speciality> _specialities = new HashSet<>();
                                faculty1.setName(faculty.text());
                                _faculties.add(faculty1);


                                Element facultyLinkElement = faculty.selectFirst("a");
                                String facultyLink;
                                if (facultyLinkElement != null) {
                                    facultyLink = facultyLinkElement.absUrl("href");
                                    Document facultyPage = Jsoup.connect(facultyLink).get();
                                    Elements rows = facultyPage.select("table.ab-table.faculty-specs tbody tr");

                                    for (Element row : rows) {
                                        if (!row.hasClass("big-caption")) {
                                            Elements tds = row.select("td");
                                            if (tds.size() > 2) {

                                                String speciality = tds.get(0).text();
                                                Speciality speciality1 = new Speciality();
                                                speciality1.setName(speciality);
                                                _specialities.add(speciality1);
                                            }
                                        }
                                    }

                                }
                                faculty1.setSpecialities(_specialities);
                            }

                        }
                    }
                    university.setFaculties(_faculties);
                    universities.add(university);
                }
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return universities;
    }
    public List<University> getFaculty(List<University> universities){
        try {
            Document document = Jsoup.connect(mainURL).get();

        }catch (IOException e){
            throw new RuntimeException();
        }
        return universities;
    }

    @Override
    public List<University> getSpecialities(List<University> universities) {
        return universities;
    }
}
