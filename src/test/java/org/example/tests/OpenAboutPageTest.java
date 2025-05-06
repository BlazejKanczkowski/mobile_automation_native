package org.example.tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.example.enums.UserCredentials;
import org.example.pages.AboutPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenAboutPageTest extends BaseTest {

    @Test
    public void testOpenAboutPage() {
        getLoginPage().login(UserCredentials.STANDARD_USER);
        Assert.assertTrue(getProductPage().isProductListVisible(), "Product page not visible after login.");

        getMenuPage().openAboutPage();

        AboutPageBase aboutPage = initPage(getDriver(), AboutPageBase.class);
        Assert.assertTrue(aboutPage.isSignUpButtonPresent(), "Sign up button is not visible on About page.");
    }
}
