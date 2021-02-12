package tests.pageobjects.scenaries;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationPage {
    String firstName = "Vasiliy",
            lastName = "Potemkin",
            email = "vasyap@mail.ru",
            gender = "Male",
            mobile = "9119119111",
            dayOfBirth = "12",
            monthOfBirth = "April",
            yearOfBirth = "1994",
            subjects = "Maths",
            hobbies = "Reading",
            picture = "noname.png",
            address = "Azeroth",
            state = "Rajasthan",
            city = "Jaipur";

    public void fillForm() {
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);
        $(byText(gender)).click();
        $("#userNumber").val(mobile);
        setBirthDate(yearOfBirth, monthOfBirth, dayOfBirth);
        $("#subjectsInput").val(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/upload/" + picture));
        $("#currentAddress").val(address);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
    }
    public void setBirthDate(String year, String month, String day) {
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();
    }

    public void checkData() {
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

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

}

