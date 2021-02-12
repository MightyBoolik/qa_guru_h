package tests.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormDemoqaTestWithFaker {
    @Disabled
    @BeforeAll
    static void setup(){
        Configuration.startMaximized = true;
    }
    @Test
    public void toolsQaTest() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                gender = "Male",
                mobile = faker.phoneNumber().subscriberNumber(10),
                dayOfBirth = "12",
                monthOfBirth = "April",
                yearOfBirth = "1994",
                subjects = "Maths",
                hobbies = "Reading",
                picture = "noname.png",
                address = faker.address().fullAddress(),
                state = "Rajasthan",
                city = "Jaipur";
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(mobile);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__day--0" +dayOfBirth).click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $(byText(hobbies)).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/upload/noname.png"));
        $("#currentAddress").setValue(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        $(".modal-content").shouldHave(
                text(firstName),
                text(lastName),
                text(gender),
                text(mobile),
                text(dayOfBirth),
                text(monthOfBirth),
                text(yearOfBirth),
                text(subjects),
                text(hobbies),
                text(picture),
                text(address),
                text(state + " " + city));




























    }
}
