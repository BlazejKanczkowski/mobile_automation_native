package org.example.tests;

import org.example.enums.UserCredentials;
import org.example.pages.LoginPageBase;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {

        getLoginPage().login(UserCredentials.STANDARD_USER);

        Assert.assertTrue(getProductPage().isProductListVisible(), "Product list is not visible – login might have failed.");

        getMenuPage().logout();
    }
    // DONE
}
