package mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mobile.dto.AddUserData;
import mobile.enums.AccountTitle;
import mobile.helper.Helper;
import mobile.locators.SignUpPopUpLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SignUpPopUpScreen extends BaseScreen {
    public SignUpPopUpScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocators.SIGN_UP_BUTTON_XPATH)
    private WebElement signUpButton;

    public void signUp() {
        waitUntilElementsIsVisible(signUpButton);
        signUpButton.click();
    }

    @AndroidFindBy(xpath = SignUpPopUpLocators.INPUT_FIRST_NAME_FIELD_XPATH)
    private WebElement inputFirstNameField;

    public void setFirstName(String firstName) {
        waitUntilElementsIsVisible(inputFirstNameField);
        inputFirstNameField.click();
        inputFirstNameField.sendKeys(firstName);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocators.INPUT_LAST_NAME_FIELD_XPATH)
    private WebElement inputLastNameField;

    public void setLastName(String lastName) {
        waitUntilElementsIsVisible(inputLastNameField);
        inputLastNameField.click();
        inputLastNameField.sendKeys(lastName);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocators.INPUT_EMAIL_FIELD_XPATH)
    private WebElement inputEmailField;

    public void setEmail(String email) {
        waitUntilElementsIsVisible(inputEmailField);
        inputEmailField.click();
        inputEmailField.sendKeys(email);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocators.INPUT_PASSWORD_FIELD_XPATH)
    private WebElement inputPasswordField;

    public void setPassword(String password) {
        waitUntilElementsIsVisible(inputPasswordField);
        inputPasswordField.click();
        inputPasswordField.sendKeys(password);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocators.INPUT_ACCEPT_PASSWORD_FIELD_XPATH)
    private WebElement inputAcceptPasswordField;

    public void setAcceptPassword(String acceptPassword) {
        waitUntilElementsIsVisible(inputAcceptPasswordField);
        inputAcceptPasswordField.click();
        inputAcceptPasswordField.sendKeys(acceptPassword);
    }

    @AndroidFindBy(xpath = SignUpPopUpLocators.FINISH_SIGN_UP_BUTTON_XPATH)
    private WebElement finishSignUp;

    public void finishSignUp() {
        waitUntilElementsIsVisible(finishSignUp);
        finishSignUp.click();
        log.info("System login: Completed");
    }

    @SneakyThrows
    public SignUpPopUpScreen registrationNewUser(AddUserData addUserData) {
        signUp();
        setFirstName(addUserData.getUserFirstName());
        setLastName(addUserData.getUserLastName());
        setEmail(addUserData.getUserEmail());
        setPassword(addUserData.getUserPassword());
        setAcceptPassword(addUserData.getUserPasswordConfirmation());
        log.info("Registration: User '{}' successful", addUserData.getUserEmail());

        finishSignUp();
        Thread.sleep(1000);
        return this;
    }

    public void verifyUserRegistered(AccountTitle accountTitle) {
        assertThat(Helper.isTextOnScreen(accountTitle.getValue()))
                .as("Check if text '%s' is visible on the screen", accountTitle.getValue())
                .isTrue();
        log.info("Verified '{}' text '%s' is visible",accountTitle.getValue());
    }
}
