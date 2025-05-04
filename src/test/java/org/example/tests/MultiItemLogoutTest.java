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
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductPageBase productPage = loginPage.login(UserCredentials.STANDARD_USER);

        List<String> products = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light");
        productPage.addProductsToCart(products);

        Assert.assertEquals(productPage.getCartCount(), products.size(), "Cart badge does not match number of added products.");

        MenuPageBase menuPage = initPage(getDriver(), MenuPageBase.class);
        menuPage.logout();

        LoginPageBase loginPageAfterLogout = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPageAfterLogout.isPageOpened(), "Not redirected to login after logout.");
    }
    //DONE
}
