package mobile.helper;

import io.appium.java_client.AppiumDriver;
import lombok.Setter;

public class Helper {
    @Setter
    private static AppiumDriver driver;

    public static boolean isTextOnScreen(String expectedTest) {
        return driver.getPageSource().contains(expectedTest);
    }


}
