package org.example.tests;

import io.appium.java_client.InteractsWithApps;
import org.example.enums.UserType;
import org.example.pages.LoginPageBase;
import org.example.utils.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ReopenAppLogoutTest extends BaseTest {

    @Test
    public void testAppReopenAfterLogin() {

        loginToAccount();

        WebDriver driver = getDriver();

        if (driver instanceof InteractsWithApps) {
            ((InteractsWithApps) driver).runAppInBackground(Duration.ofSeconds(5));
        } else {
            Assert.fail("Driver does not support app control.");
        }

        LoginPageBase loginPageAfterRestart = initPage(driver, LoginPageBase.class);
        Assert.assertFalse(loginPageAfterRestart.isPageOpened(), "User is not logged in after reopening the app.");
    }
}
