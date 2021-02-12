package tests.pageobjects.scenaries;

import org.junit.jupiter.api.Test;
import tests.TestBase;
public class StudentRegistrationForm extends TestBase {
    StudentRegistrationPage studentRegistrationPage;


    @Test
    void successfulFillFormTest() {
        studentRegistrationPage = new StudentRegistrationPage();

        studentRegistrationPage.openPage();
        studentRegistrationPage.fillForm();
        studentRegistrationPage.checkData();


    }
}

