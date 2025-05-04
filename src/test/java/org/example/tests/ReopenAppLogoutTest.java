package org.example.tests;

import io.appium.java_client.android.AndroidDriver;
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
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductPageBase productPage = loginPage.login(UserCredentials.STANDARD_USER);
        Assert.assertTrue(productPage.isProductListVisible(), "Product list not visible after login.");

        WebDriver driver = getDriver();

        if (driver instanceof AndroidDriver) {
            String appPackage = "com.swaglabsmobileapp";
            ((AndroidDriver) driver).terminateApp(appPackage);
            ((AndroidDriver) driver).activateApp(appPackage);
        } else {
            Assert.fail("Not an AndroidDriver – cannot simulate app restart.");
        }

        LoginPageBase loginPageAfterRestart = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPageAfterRestart.isPageOpened(), "User is still logged in after reopening the app.");
    }
    //TO DO
}
