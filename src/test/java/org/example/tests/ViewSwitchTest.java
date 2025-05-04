package org.example.tests;

import org.example.enums.UserCredentials;
import org.example.pages.LoginPageBase;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewSwitchTest extends BaseTest {

    @Test
    public void testSwitchBetweenListAndGridView() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductPageBase productPage = loginPage.login(UserCredentials.STANDARD_USER);

        Assert.assertTrue(productPage.isProductListVisible(), "Product list not visible.");

        productPage.switchView();

        Assert.assertTrue(productPage.isProductListVisible(), "Product list not visible after switching view.");
    }
    //DONE
}
