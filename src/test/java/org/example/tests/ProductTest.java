package org.example.tests;

import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductTest extends BaseTest {

    @Test
    public void verifyOpeningProductDetails() {
        ProductPageBase productPage = loginToAccount();
        productPage.openProductByName("Sauce Labs Backpack");
        Assert.assertTrue(productPage.isDetailsPageOpened(), "Details page not opened.");
    }

    @Test
    public void verifyRemovingProductFromCart() {
        ProductPageBase productPage = loginToAccount();
        productPage.addProductsToCart(List.of("Sauce Labs Backpack"));
        productPage.removeProductFromCartByName("Sauce Labs Backpack");
        Assert.assertEquals(productPage.getCartCount(), 0, "Product not removed from cart.");
    }
}
