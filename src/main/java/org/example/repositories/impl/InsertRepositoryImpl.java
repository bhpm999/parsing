package org.example.repositories.impl;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.domain.Faculty;
import org.example.domain.University;
import org.example.repositories.InsertRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
@RequiredArgsConstructor
public class InsertRepositoryImpl implements InsertRepository {
    @NonNull
    private WebDriver driver;
    private final String authorisationUrl = "http://127.0.0.1:8000/admin";
    private final String addUnivUrl = "http://127.0.0.1:8000/admin/university/university/add/";
    private final String addFacultyUrl = "http://127.0.0.1:8000/admin/university/faculty/add/";

    @Override
    public void insertUniversities(List<University> universities) {

        WebDriverManager.chromedriver().setup();
        driver.get(addUnivUrl);
        WebElement univInputField = driver.findElement(By.name("university_name"));
        WebElement addUnivButton = driver.findElement(By.name("_addanother"));
        WebElement townInputField = driver.findElement(By.name("city"));
        try {
            for (University university : universities) {
                townInputField.clear();
                townInputField.sendKeys(university.getTown());
                univInputField.clear();
                univInputField.sendKeys(university.getName());
                addUnivButton.click();
                Thread.sleep(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void insertAuthorisation(){
        try {
            String login = "kurs";
            String password = "12345";
            WebDriverManager.chromedriver().setup();
            driver.get(authorisationUrl);
            WebElement loginInput = driver.findElement(By.name("username"));
            loginInput.clear();
            loginInput.sendKeys(login);
            WebElement passwordInput = driver.findElement(By.name("password"));
            passwordInput.clear();
            passwordInput.sendKeys(password);
            WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit'][value='Войти']"));
            loginButton.click();
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void insertFaculty(List<University> universities){
        WebDriverManager.chromedriver().setup();
        driver.get(addFacultyUrl);
        WebElement selectUniv = driver.findElement(By.name("university"));
        WebElement facultyInput = driver.findElement(By.name("faculty_name"));
        WebElement addFacultyButton = driver.findElement(By.name("_addanother"));
        Select select = new Select(selectUniv);
        try {
            for (University university : universities) {
                select.selectByValue(university.getName());
                for (Faculty faculty : university.getFaculties()) {
                    select.selectByValue(university.getName());
                    facultyInput.clear();
                    facultyInput.sendKeys(faculty.getName());
                    addFacultyButton.click();
                    Thread.sleep(2000);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
