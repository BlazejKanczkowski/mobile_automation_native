package org.example.tests;

import org.example.enums.UserCredentials;
import org.example.pages.*;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CheckoutFlowTest extends BaseTest {

    @Test
    public void testCompleteCheckoutWithMultipleItems() {

        List<String> products = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light");

        getLoginPage().login(UserCredentials.STANDARD_USER);
        Assert.assertTrue(getProductPage().isProductListVisible(), "Product page not loaded.");


        getProductPage().addProductsToCart(products);
        Assert.assertEquals(getProductPage().getCartCount(), products.size(), "Incorrect cart badge count.");
        getProductPage().clickCartIcon();
        getCartPage().scrollToCheckoutButton();
        Assert.assertTrue(getCartPage().isCheckoutButtonPresent(), "Checkout button not found.");

        getCartPage().clickCheckout();

        getCheckoutPage().fillForm("User", "LastName", "12345");
        getCheckoutPage().scrollToFinishButton();
        getCheckoutPage().finishOrder();

        Assert.assertTrue(getCheckoutPage().isConfirmationDisplayed(), "Order confirmation not visible.");
    }
}
