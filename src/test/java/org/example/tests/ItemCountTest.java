package org.example.tests;

import org.example.enums.SortOption;
import org.example.enums.UserCredentials;
import org.example.pages.LoginPageBase;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemCountTest extends BaseTest {

    @Test
    public void testProductCountBeforeAndAfterSort() {

        getLoginPage().login(UserCredentials.STANDARD_USER);

        Assert.assertTrue(getProductPage().isProductListVisible(), "Product list not visible.");

        int countBefore = getProductPage().getDisplayedPrices().size();

        getProductPage().sortBy(SortOption.PRICE_LOW_TO_HIGH);

        int countAfter = getProductPage().getDisplayedPrices().size();

        Assert.assertEquals(countAfter, countBefore, "Number of products changed after sort.");

        getMenuPage().logout();
    }
    //DONE
}
