package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormWithFakerTests {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData data = new TestData();


    @Test
    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());



        //заполнение всех полей

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.userEmail)
                .setGender(data.gender)
                .setUserNumber(data.userNumber)
                .setDateOfBirth(data.day, data.month, data.year)
                .setSubjects(data.subject)
                .setHobbies(data.hobbies)
                .uploadPicture()
                .setCurrentAddress(data.streetAddress)
                .setState(data.state)
                .setCity(data.city)
                .pressSubmit();


        //Проверка
        registrationPage.checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Student Email", data.userEmail)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.userNumber)
                .checkResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                .checkResult("Subjects", data.subject)
                .checkResult("Hobbies", data.hobbies)
                .checkResult("Picture", "PictureForTest.png")
                .checkResult("Address", data.streetAddress)
                .checkResult("State and City", data.state + " " + data.city);
    }

    @Test
    void minimalDataTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        //заполнение обязательных полей

        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setEmail(data.userEmail)
                .setUserNumber(data.userNumber)
                .pressSubmit();

        registrationPage.checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Student Email", data.userEmail)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.userNumber);

    }

    @Test
    void negativeTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());


        registrationPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .pressSubmit()
                .checkNotCompleteForm();


    }

}
