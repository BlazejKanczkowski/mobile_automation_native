package org.example.tests;

import org.example.enums.UserType;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewSwitchTest extends BaseTest {

    @Test
    public void testSwitchBetweenListAndGridView() {

        loginToAccount();
        Assert.assertTrue(getProductPage().isProductListVisible(), "Product list not visible.");

        getProductPage().switchView();
        Assert.assertTrue(getProductPage().isProductListVisible(), "Product list not visible after switching view.");
    }
}
