package org.example.tests;

import org.example.pages.ProductListPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductTest extends BaseTest {

    @Test
    public void verifyOpeningProductDetails() {
        ProductListPageBase productPage = loginAsStandardUser(true);
        productPage.openProductByName("Sauce Labs Backpack");
        Assert.assertTrue(productPage.isDetailsPageOpened(), "Details page not opened.");
    }

    @Test
    public void verifyRemovingProductFromCart() {
        int EXPECTED_EMPTY_CART_COUNT = 0;
        ProductListPageBase productPage = loginAsStandardUser(true);
        productPage.addProductsToCart(List.of("Sauce Labs Backpack"));
        productPage.removeProductFromCartByName("Sauce Labs Backpack");
        Assert.assertEquals(productPage.getCartCount(), EXPECTED_EMPTY_CART_COUNT, "Product not removed from cart.");
    }
}
