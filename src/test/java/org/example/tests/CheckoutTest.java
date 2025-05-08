package org.example.tests;

import org.example.pages.CartPageBase;
import org.example.pages.CheckoutPageBase;
import org.example.pages.ProductListPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CheckoutTest extends BaseTest {

    @Test
    public void testCompleteCheckoutWithMultipleItems() {

        List<String> products = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light");

        ProductListPageBase productPage = loginAsStandardUser(true);
        Assert.assertTrue(productPage.isProductListVisible(), "Product page not loaded.");

        productPage.addProductsToCart(products);
        Assert.assertEquals(productPage.getCartCount(), products.size(), "Incorrect cart badge count.");

        productPage.clickCartIcon();

        CartPageBase cartPage = getCartPage();
        cartPage.scrollToCheckoutButton();
        Assert.assertTrue(cartPage.isCheckoutButtonPresent(), "Checkout button not found.");
        cartPage.clickCheckout();

        CheckoutPageBase checkoutPageBase = getCheckoutPage();
        checkoutPageBase.fillForm("User", "LastName", "12345");
        checkoutPageBase.scrollToFinishButton();
        checkoutPageBase.finishOrder();

        Assert.assertTrue(checkoutPageBase.isConfirmationDisplayed(), "Order confirmation not visible.");

        //to do: implementing total price check using big decimal
    }
}
