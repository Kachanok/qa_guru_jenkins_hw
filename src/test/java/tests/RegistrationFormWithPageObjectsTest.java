package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormWithPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    @DisplayName("Заполнить все поля формы Practice")
    void fillFormTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        //заполнение всех полей формы
        registrationPage.openPage()
                .setFirstName("Ann")
                .setLastName("Smith")
                .setEmail("annsmth@yes.com")
                .setGender("Female")
                .setUserNumber("8800222336")
                .setDateOfBirth("10", "September", "1992")
                .setSubjects("English")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setHobbies("Music")
                .uploadPicture()
                .setCurrentAddress("220 East Chicago Avenue,Chicago")
                .setState("Uttar Pradesh")
                .setCity("Lucknow")
                .pressSubmit();


        //Проверка
        registrationPage.checkResult("Student Name", "Ann Smith")
                .checkResult("Student Email", "annsmth@yes.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8800222336")
                .checkResult("Date of Birth", "10 September,1992")
                .checkResult("Subjects", "English")
                .checkResult("Hobbies", "Sports, Reading, Music")
                .checkResult("Picture", "PictureForTest.png")
                .checkResult("Address", "220 East Chicago Avenue,Chicago")
                .checkResult("State and City", "Uttar Pradesh Lucknow");
    }

    @Test
    @DisplayName("Заполнить обязательные поля формы Practice")
    void minimalDataTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        //заполнение обязательных полей

        registrationPage.openPage()
                .setFirstName("Ann")
                .setLastName("Smith")
                .setGender("Female")
                .setEmail("annsmth@yes.com")
                .setUserNumber("8800222336")
                .pressSubmit();

        registrationPage.checkResult("Student Name", "Ann Smith")
                .checkResult("Student Email", "annsmth@yes.com")
                .checkResult("Gender", "Female")
                .checkResult("Mobile", "8800222336");

    }

    @Test
    @DisplayName("Заполнить обязательные поля формы Practice частично")
    void negativeTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        registrationPage.openPage()
                .setFirstName("Ann")
                .setLastName("Smith")
                .setGender("Female")
                .pressSubmit()
                .checkNotCompleteForm();


    }

}

