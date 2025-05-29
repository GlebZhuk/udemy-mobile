package tests.account;

import mobile.enums.LoginTitle;
import mobile.helper.TestDescription;
import mobile.screens.JoomHomeScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static mobile.enums.LoginTitle.LOGIN_TITLE;

public class GetProfileScreenTest extends BaseTest {


    @Test
    @DisplayName("Open login screen")
    @TestDescription("Close advertisment, skip the quiz, open login screen")
    public void testGetLoginScreen() {
        JoomHomeScreen joomHomeScreen = new JoomHomeScreen(driver);
        joomHomeScreen
                //.closeAdvertisement()
                //.skipQuiz()
                .openLoginScreen()
                .verifyLoginScreenOpen(LOGIN_TITLE);
    }
}
