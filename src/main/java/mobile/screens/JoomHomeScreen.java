package mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import mobile.locators.JoomHomeLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Slf4j
@Setter
public class JoomHomeScreen extends BaseScreen{
    public JoomHomeScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public JoomHomeScreen closeAdvertisement() {
        int xCoordinate = 1250;
        int yCoordinate= 293;

        tapByCoordinate(xCoordinate,yCoordinate);
        log.info("Advertisement closed");
        return new JoomHomeScreen(driver);
    }

    @AndroidFindBy(xpath = JoomHomeLocators.SKIP_SPINNING_WHEEL_XPATH)
    private WebElement skipQuizButton;

    public JoomHomeScreen skipQuiz() {
        waitUntilElementsIsVisible(skipQuizButton);
        skipQuizButton.click();
        log.info("Spinning wheel skipped");
        return new JoomHomeScreen(driver);
    }

    @AndroidFindBy(xpath = JoomHomeLocators.PROFILE_BUTTON_XPATH)
    private WebElement openProfileButton;

    public ProfileScreen openLoginScreen() {
        waitUntilElementsIsVisible(openProfileButton);
        openProfileButton.click();
        log.info("Profile opened");
        return new ProfileScreen(driver);
    }
}
