package org.example.tests;

import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void testLogoutFlow() {

        loginAsStandardUser(true);
        Assert.assertTrue(getProductPage().isProductListVisible(), "Product list not visible – login might have failed.");

        getMenuPage().logout();
        Assert.assertTrue(getLoginPage().isPageOpened(), "Login page not shown after logout.");
    }
}
