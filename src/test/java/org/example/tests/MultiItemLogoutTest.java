package org.example.tests;

import org.example.enums.UserCredentials;
import org.example.pages.LoginPageBase;
import org.example.pages.MenuPageBase;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class MultiItemLogoutTest extends BaseTest {

    @Test
    public void testAddMultipleItemsThenLogout() {

        List<String> products = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light");

        getLoginPage().login(UserCredentials.STANDARD_USER);
        Assert.assertTrue(getProductPage().isProductListVisible(), "Product page not loaded.");

        getProductPage().addProductsToCart(products);
        Assert.assertEquals(getProductPage().getCartCount(), products.size(), "Cart badge does not match number of added products.");

        getMenuPage().logout();
        Assert.assertTrue(getLoginPage().isPageOpened(), "Not redirected to login after logout.");
    }
}
