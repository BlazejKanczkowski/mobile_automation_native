package org.example.tests;

import io.appium.java_client.InteractsWithApps;
import org.example.enums.UserCredentials;
import org.example.pages.LoginPageBase;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ReopenAppLogoutTest extends BaseTest {

    @Test
    public void testAppReopenAfterLogin() {
        getLoginPage().login(UserCredentials.STANDARD_USER);

        WebDriver driver = getDriver();

        if (driver instanceof InteractsWithApps) {
            InteractsWithApps appInteraction = (InteractsWithApps) driver;
            appInteraction.runAppInBackground(Duration.ofSeconds(5));
        } else {
            Assert.fail("Driver does not support app control.");
        }

        LoginPageBase loginPageAfterRestart = initPage(getDriver(), LoginPageBase.class);
        Assert.assertFalse(loginPageAfterRestart.isPageOpened(), "User is not logged in after reopening the app.");
    }
}
