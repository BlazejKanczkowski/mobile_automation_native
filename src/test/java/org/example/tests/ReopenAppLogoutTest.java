package org.example.tests;

import io.appium.java_client.InteractsWithApps;
import org.example.enums.UserCredentials;
import org.example.pages.LoginPageBase;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReopenAppLogoutTest extends BaseTest {

    @Test
    public void testAppReopenAfterLogin() {

        getLoginPage().login(UserCredentials.STANDARD_USER);

        WebDriver driver = getDriver();

        if (driver instanceof InteractsWithApps) {
            InteractsWithApps appInteraction = (InteractsWithApps) driver;
            String appPackage = "com.swaglabsmobileapp";
            appInteraction.terminateApp(appPackage);
            appInteraction.activateApp(appPackage);
        } else {
            Assert.fail("Driver does not support app control (terminate/activate).");
        }

        LoginPageBase loginPageAfterRestart = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPageAfterRestart.isPageOpened(), "User is still logged in after reopening the app.");
    }
    //DONE
}
