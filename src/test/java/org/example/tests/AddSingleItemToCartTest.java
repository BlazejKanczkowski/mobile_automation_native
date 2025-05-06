package org.example.tests;

import org.example.enums.UserCredentials;
import org.example.pages.LoginPageBase;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddSingleItemToCartTest extends BaseTest {

    @Test
    public void testAddOneItemToCart() {

        getLoginPage().login(UserCredentials.STANDARD_USER);

        Assert.assertTrue(getProductPage().isProductListVisible(), "Product page not loaded.");

        getProductPage().addProductToCartByName("Sauce Labs Backpack");

        int cartCount = getProductPage().getCartCount();
        Assert.assertEquals(cartCount, 1, "Cart badge count should be 1 after adding one product.");

        getMenuPage().logout();
    }
    //DONE
}
