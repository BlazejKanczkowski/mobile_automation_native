package org.example.tests;

import org.example.enums.UserCredentials;
import org.example.pages.LoginPageBase;
import org.example.pages.MenuPageBase;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogoutFlow() {

        getLoginPage().login(UserCredentials.STANDARD_USER);

        Assert.assertTrue(getProductPage().isProductListVisible(), "Product list not visible – login might have failed.");

        getMenuPage().logout();
        Assert.assertTrue(getLoginPage().isPageOpened(), "Login page not shown after logout.");
    }
    //DONE
}
