package org.example.tests;

import org.example.enums.UserType;
import org.example.pages.LoginPageBase;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductDetailsTest extends BaseTest {

    @Test
    public void testOpenProductDetails() {

        ProductPageBase productPage = loginToAccount();

        productPage.openProductDetailsByName("Sauce Labs Backpack");

        Assert.assertTrue(productPage.isDetailsPageOpened(), "Details page not opened.");
    }
}
