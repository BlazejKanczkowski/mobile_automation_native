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
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened.");

        ProductPageBase productPage = loginPage.login(UserCredentials.STANDARD_USER);
        Assert.assertTrue(productPage.isProductListVisible(), "Product list not visible – login might have failed.");

        MenuPageBase menuPage = initPage(getDriver(), MenuPageBase.class);
        menuPage.logout();

        LoginPageBase loginPageAfterLogout = initPage(getDriver(), LoginPageBase.class);
        Assert.assertTrue(loginPageAfterLogout.isPageOpened(), "Login page not shown after logout.");
    }
}
