package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import pages.RegistrationPage;

public class PracticeFormWithJavaFaker extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    TestData testData = new TestData();

    @Test
    @Tag("Registration")
    @Owner("Kwlad1ck")
    @DisplayName("Заполнение формы регистрации с проверкой введеных результатов")
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .checkDialogModal()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.userGender)
                .setPhoneNumber(testData.userPhoneNumber)
                .setDateOfBirth(testData.dayRandom, testData.monthRandom, testData.yearRandom)
                .setUserSubjects(testData.userSubjects)
                .setUserHobbies(testData.userHobbies)
                .uploadPicture(testData.loadPicture)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.randomState)
                .setCity(testData.randomCity)
                .clickSubmitButton();

        registrationPage.checkResultResponsive("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultResponsive("Student Email", testData.userEmail)
                .checkResultResponsive("Gender", testData.userGender)
                .checkResultResponsive("Mobile", testData.userPhoneNumber)
                .checkResultResponsive("Date of Birth", testData.setDayRandom + " " + testData.monthRandom + "," + testData.yearRandom)
                .checkResultResponsive("Subjects", testData.userSubjects)
                .checkResultResponsive("Hobbies", testData.userHobbies)
                .checkResultResponsive("Picture", testData.loadPicture)
                .checkResultResponsive("Address", testData.currentAddress)
                .checkResultResponsive("State and City", testData.randomState + " " + testData.randomCity);
    }

    @Tag("SimpleRegistration")
    @Owner("Kwlad1ck")
    @DisplayName("Заполнение упращенной формы регистрации с проверкой введеных результатов")
    @Test
    void minimalDataForRegistrationTest() {
        registrationPage.openPage()
                .checkDialogModal()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.userGender)
                .setPhoneNumber(testData.userPhoneNumber)
                .clickSubmitButton();

        registrationPage.checkResultResponsive("Student Name", testData.firstName + " " + testData.lastName)
                .checkResultResponsive("Gender", testData.userGender)
                .checkResultResponsive("Mobile", testData.userPhoneNumber);
    }

    @Tag("Negative")
    @Owner("Kwlad1ck")
    @DisplayName("Негативный тест заполнения формы")
    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .checkDialogModal()
                .clickSubmitButton()
                .validationMatching("border-color", "rgb(220, 53, 69)");
    }
}


