package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            genderWrapperInput = $("#genterWrapper"),
            currentAddressInput = $("#currentAddress"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            selectState = $("#react-select-3-input"),
            selectCity = $("#react-select-4-input"),
            submitButton = $("#submit"),
            tableResponsive = $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.sendKeys(value);

        return this;
    }


    public RegistrationPage setLastName(String value) {
        lastNameInput.sendKeys(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.sendKeys(value);

        return this;
    }


    public RegistrationPage setGender(String value) {
        genderWrapperInput.$(byText(value)).click();

        return this;
    }


    public RegistrationPage setUserNumber(String value) {
        userNumberInput.sendKeys(value);

        return this;
    }


    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPicture() {
        uploadPictureInput.uploadFromClasspath("PictureForTest.png");

        return this;
    }

    public RegistrationPage setState(String value) {
        selectState.val(value).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String value) {
        selectCity.val(value).pressEnter();

        return this;
    }

    public RegistrationPage pressSubmit() {
        submitButton.pressEnter();
        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        tableResponsive.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    public void checkNotCompleteForm() {
        firstNameInput.shouldHave(Condition.cssValue("border-color", "rgb(40, 167, 69)"));
    }
}
