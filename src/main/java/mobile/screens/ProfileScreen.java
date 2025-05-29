package mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import mobile.enums.LoginTitle;
import mobile.helper.Helper;
import mobile.locators.LoginLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ProfileScreen extends BaseScreen {
    public ProfileScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void verifyLoginScreenOpen(LoginTitle loginTitle) {
        assertThat(Helper.isTextOnScreen(loginTitle.getValue()))
                .as("Check if the text '%s' is visible on screen", loginTitle.getValue())
                .isTrue();

        log.info("Verified '{}' text is visible", loginTitle.getValue());
    }

    @AndroidFindBy(xpath = LoginLocators.LOGIN_BUTTON_XPATH)
    private WebElement registrationButton;

    public ProfileScreen openRegistrationForm() {
        waitUntilElementsIsVisible(registrationButton);
        registrationButton.click();
        log.info("Login profile: Opened");
        return this;
    }

    @AndroidFindBy(xpath = LoginLocators.MORE_OPTIONS_BUTTON_XPATH)
    WebElement moreOptionButton;

    private void showMoreOption() {
        waitUntilElementsIsVisible(moreOptionButton);
        moreOptionButton.click();
    }

    @AndroidFindBy(xpath = LoginLocators.LOGIN_WITH_EMAIL_BUTTON_XPATH)
    private WebElement signUpWithEmailButton;

    public SignUpPopUpScreen signUpPopUpScreen() {
        showMoreOption();

        waitUntilElementsIsVisible(signUpWithEmailButton);
        signUpWithEmailButton.click();
        log.info("Sign up with Email: Accepted");
        return new SignUpPopUpScreen(driver);
    }
}
