package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {
    Faker faker = new Faker(new Locale("eng"));


    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            day = String.valueOf(faker.number().numberBetween(1, 31)),
            month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"),
            year = String.valueOf(faker.number().numberBetween(1990, 2000)),
            subject = faker.options().option("Maths", "History", "English"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            streetAddress = faker.address().streetAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = setRandomCity(state);

    public String setRandomCity(String state) {
        switch (state) {
            case "NCR":
                return faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh":
                return faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana":
                return faker.options().option("Karnal", "Panipat");
            case "Rajasthan":
                return faker.options().option("Jaipur", "Jaiselmer");
            default:
                return null;
        }

    }
}
