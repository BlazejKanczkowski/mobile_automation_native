package org.example.tests;

import org.example.enums.UserCredentials;
import org.example.pages.*;
import org.example.utils.BaseTest;
import org.example.utils.MobileScrollUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CheckoutFlowTest extends BaseTest {

    @Test
    public void testCompleteCheckoutWithMultipleItems() {
        List<String> products = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light");

        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductPageBase productPage = loginPage.login(UserCredentials.STANDARD_USER);
        Assert.assertTrue(productPage.isProductListVisible(), "Product page not loaded.");

        productPage.addProductsToCart(products);
        Assert.assertEquals(productPage.getCartCount(), products.size(), "Incorrect cart badge count.");

        CartPageBase cartPage = productPage.clickCartIcon();
        //to do
        MobileScrollUtil.scrollDownMultipleTimes(getDriver(), 2);
        Assert.assertTrue(cartPage.isCheckoutButtonPresent(), "Checkout button not found.");

        CheckoutPageBase checkoutPage = cartPage.clickCheckout();

        checkoutPage.fillForm("User", "LastName", "12345");
        checkoutPage.finishOrder();

        Assert.assertTrue(checkoutPage.isConfirmationDisplayed(), "Order confirmation not visible.");
    }
}
