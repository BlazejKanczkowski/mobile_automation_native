package org.example.tests;

import org.example.enums.UserType;
import org.example.pages.AboutPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenAboutPageTest extends BaseTest {

    @Test
    public void testOpenAboutPage() {

        loginAsStandardUser(true);
        Assert.assertTrue(getProductPage().isProductListVisible(), "Product page not visible after login.");

        getMenuPage().openAboutPage();

        AboutPageBase aboutPage = initPage(getDriver(), AboutPageBase.class);
        Assert.assertTrue(aboutPage.isSignUpButtonPresent(), "Sign up button is not visible on About page.");
    }
}
