package tests.account;

import mobile.dto.AddUserData;
import mobile.enums.AccountTitle;
import mobile.generator.FakeRandomGenerator;
import mobile.helper.TestDescription;
import mobile.screens.JoomHomeScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static mobile.enums.AccountTitle.NEW_USER_DATA;
import static mobile.utils.Constants.*;

public class RegistrationUserTest extends BaseTest {

    private final AccountTitle newUserData = FakeRandomGenerator.getRandomOption(AccountTitle.class);

    private final AddUserData addUserData = AddUserData.builder()
            .userFirstName(USER_FIRST_NAME)
            .userLastName(USER_LAST_NAME)
            .userEmail(USER_EMAIL)
            .userPassword(USER_PASSWORD)
            .userPasswordConfirmation(USER_PASSWORD_CONFIRMATION)
            .build();

    @Test
    @Tag("acceptanceTest")
    @DisplayName("User registration")
    @TestDescription("Close advertisement, skip the quiz, open login screen and sign up")
    public void testRegistrationUser() {
        JoomHomeScreen joomHomeScreen = new JoomHomeScreen(driver);
        joomHomeScreen
                .openLoginScreen()
                .openRegistrationForm()
                .signUpPopUpScreen()
                .registrationNewUser(addUserData)
                .verifyUserRegistered(NEW_USER_DATA);
    }
}
