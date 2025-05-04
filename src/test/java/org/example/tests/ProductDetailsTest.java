package org.example.tests;

import org.example.enums.UserCredentials;
import org.example.pages.LoginPageBase;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTest extends BaseTest {

    @Test
    public void testOpenProductDetails() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductPageBase productPage = loginPage.login(UserCredentials.STANDARD_USER);

        productPage.openProductDetails("Sauce Labs Backpack");

        Assert.assertTrue(productPage.isDetailsPageOpened(), "Details page not opened.");
    }
//DONE
}
