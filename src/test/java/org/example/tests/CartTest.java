package org.example.tests;

import org.example.components.ProductDetailsComponentBase;
import org.example.components.TopMainMenuComponentBase;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void testAddProductToCart() {
        ProductPageBase productPage = loginToAccount();
        Assert.assertTrue(productPage.isProductListVisible(), "Product page not loaded.");

        TopMainMenuComponentBase topMenu = productPage.getTopMainMenu();
        int initialItemCount = topMenu.getCartItemCount();

        productPage.addProductToCartByName("Sauce Labs Backpack");

        int updatedItemCount = topMenu.getCartItemCount();

        Assert.assertTrue(updatedItemCount > initialItemCount, "Product was not successfully added to the cart.");
    }

}
