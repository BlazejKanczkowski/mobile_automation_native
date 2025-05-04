package org.example.tests;

import io.appium.java_client.android.AndroidDriver;
import org.example.enums.UserCredentials;
import org.example.pages.LoginPageBase;
import org.example.pages.MenuPageBase;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BackFromAboutTest extends BaseTest {

    @Test
    public void testBackFromAboutToApp() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductPageBase productPage = loginPage.login(UserCredentials.STANDARD_USER);
        Assert.assertTrue(productPage.isProductListVisible(), "Product page not visible after login.");

        MenuPageBase menuPage = initPage(getDriver(), MenuPageBase.class);
        menuPage.openAboutPage();

        WebDriver driver = getDriver();

        if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).navigate().back();
        } else {
            Assert.fail("Driver is not AndroidDriver – cannot perform Android back.");
        }

        Assert.assertTrue(productPage.isProductListVisible(), "Product page not visible after returning from About.");
    }
    // TO DO
}
