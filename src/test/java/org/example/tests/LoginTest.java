package org.example.tests;

import org.example.enums.UserType;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testValidLogin() {

        loginAsStandardUser(true);
        Assert.assertTrue(getProductPage().isProductListVisible(), "Product list is not visible – login might have failed.");
    }
}
