import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormDemoqaTest {
    @BeforeAll
    static void setup(){
        Configuration.startMaximized = true;
    }
    @Test
    void toolsQaTest() {
        open("https://demoqa.com/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Vasiliy");
        $("#lastName").setValue("Potemkin");
        $("#userEmail").setValue("vasyap@mail.ru");
        $(byText("Male")).click();
        $("#userNumber").setValue("9119119111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(byText("1994")).click();
        $(".react-datepicker__month-select").click();
        $(byText("April")).click();
        $(".react-datepicker__day--012").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/upload/noname.png"));
        $("#currentAddress").setValue("Azeroth");
        $("#state").click();
        $(byText("Rajasthan")).click();
        $("#city").click();
        $(byText("Jaipur")).click();
        $("#submit").click();
        $(".modal-content").shouldHave(
                text("Student Name Vasiliy Potemkin"),
                text("Student Email vasyap@mail.ru"),
                text("Gender Male"),
                text("Mobile 9119119111"),
                text("Date of Birth 12 April,1994"),
                text("Subjects Maths"),
                text("Hobbies Reading"),
                text("Picture noname.png"),
                text("Address Azeroth"),
                text("State and City Rajasthan Jaipur"));




























    }
}
