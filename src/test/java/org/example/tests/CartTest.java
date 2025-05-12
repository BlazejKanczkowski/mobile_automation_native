package org.example.tests;

import org.example.pages.CartPageBase;
import org.example.pages.ProductListPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CartTest extends BaseTest {

    @Test
    public void testAddProductToCart() {

        List<String> product = List.of("Sauce Labs Backpack");

        ProductListPageBase productPage = loginAsStandardUser(true);
        Assert.assertTrue(productPage.isProductListVisible(), "Product page not loaded.");

        productPage.addProductsToCart(product);
        CartPageBase cartPage = productPage.clickCartIcon();

        Assert.assertTrue(cartPage.checkIfVisibleInCart("Sauce Labs Backpack"), "Product not in cart");
    }

}
