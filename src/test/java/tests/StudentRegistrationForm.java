package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class StudentRegistrationForm extends TestBase {

    @Test
    public void successfulFillFormTest() {
        Faker faker = new Faker();
        StudentRegistrationPage studentRegistrationPage = new StudentRegistrationPage();
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                gender = "Male",
                mobile = faker.phoneNumber().subscriberNumber(10),
                day = "12",
                month = "April",
                year = "1994",
                subjects = "Maths",
                hobbies = "Reading",
                picture = "noname.png",
                address = faker.address().fullAddress(),
                state = "Rajasthan",
                city = "Jaipur",
                url = "https://demoqa.com/automation-practice-form";

        StudentRegistrationPage.openPage(url);
        StudentRegistrationPage.setFirstName(firstName);
        StudentRegistrationPage.setLastName(lastName);
        StudentRegistrationPage.setEmail(email);
        StudentRegistrationPage.setGender(gender);
        StudentRegistrationPage.setPhoneNumber(mobile);
        StudentRegistrationPage.setBirthDate(year, month, day);
        StudentRegistrationPage.setSubjects(subjects);
        StudentRegistrationPage.setHobbies(hobbies);
        StudentRegistrationPage.uploadFile(picture);
        StudentRegistrationPage.setAddress(address);
        StudentRegistrationPage.chooseState(state);
        StudentRegistrationPage.chooseCity(city);
        StudentRegistrationPage.clickSubmit();
        StudentRegistrationPage.checkData(firstName, lastName, email, gender, mobile, year, month, day, subjects, hobbies, picture);
    }
}


