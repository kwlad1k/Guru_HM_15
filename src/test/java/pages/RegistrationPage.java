package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import pages.components.DataPickerComponent;
import pages.components.ModalResponsiveComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement dialogRoot = $(".fc-consent-root .fc-cta-consent"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNubmerInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressForm = $("#currentAddress"),
            selectState = $("#react-select-3-input"),
            selectCity = $("#react-select-4-input"),
            submitButton = $("#submit"),
            calenderInput = $("#dateOfBirthInput"),
            tableResponsive = $(".table-responsive");

    DataPickerComponent dataPickerComponent = new DataPickerComponent();
    ModalResponsiveComponent modalResponsiveComponent = new ModalResponsiveComponent();


    @Step("Открытие страницы и удаление футера и банера")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    @Step("Закрытие диалогового окна при его наличии ")
    public RegistrationPage checkDialogModal() {
        int counter = 0;
        while (counter < 3) {
            if (dialogRoot.isDisplayed()) {
                dialogRoot.click();
                break;
            }
            sleep(1000);
            counter++;
        }
        return this;
    }

    @Step("Ввод имени: {value}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    @Step("Ввод фамилии: {value}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    @Step("Ввод Email: {value}")
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    @Step("Установка гендера: {value}")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }
    @Step("Ввод номера телефона: {value}")
    public RegistrationPage setPhoneNumber(String value) {
        userNubmerInput.setValue(value);

        return this;
    }
    @Step("Установка Subjects: {value}")
    public RegistrationPage setUserSubjects(String value) {
        subjectInput.setValue(value).sendKeys(Keys.ENTER);

        return this;
    }
    @Step("Установка хобби: {value}")
    public RegistrationPage setUserHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }
    @Step("Загрузка картинки {value}")
    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }
    @Step("Ввод текущего адреса: {value}")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressForm.setValue(value);

        return this;
    }
    @Step("Выбор Штата: {value}")
    public RegistrationPage setState(String value) {
        selectState.setValue(value).sendKeys(Keys.ENTER);

        return this;
    }
    @Step("Выбор города: {value}")
    public RegistrationPage setCity(String value) {
        selectCity.setValue(value).sendKeys(Keys.ENTER);

        return this;
    }
    @Step("Нажатие на кнопку Submit")
    public RegistrationPage clickSubmitButton() {
        submitButton.click();

        return this;
    }
    @Step("Установка даты рождения {day}.{month}.{year}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calenderInput.click();
        dataPickerComponent.setDate(day, month, year);

        return this;
    }
    @Step("Проверка ключа {key} с веденным значением: '{value}'")
    public RegistrationPage checkResultResponsive(String key, String value) {
        tableResponsive.shouldBe(visible);
        modalResponsiveComponent.checkResult(key, value);

        return this;
    }
    @Step("Проверка валидации компонента")
    public RegistrationPage validationMatching(String key, String value) {
        firstNameInput.shouldBe(cssValue(key, value));
        lastNameInput.shouldBe(cssValue(key, value));
        userNubmerInput.shouldBe(cssValue(key, value));
        $("label[for='gender-radio-1']").shouldBe(cssValue(key, value));
        $("label[for='gender-radio-2']").shouldBe(cssValue(key, value));
        $("label[for='gender-radio-1']").shouldBe(cssValue(key, value));

        return this;
    }
}

