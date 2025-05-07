package org.example.tests;

import org.example.enums.SortOption;
import org.example.enums.UserType;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemCountTest extends BaseTest {

    @Test
    public void testProductCountBeforeAndAfterSort() {

        loginToAccount();
        Assert.assertTrue(getProductPage().isProductListVisible(), "Product list not visible.");

        int countBefore = getProductPage().getProductPrices().size();
        getProductPage().sortBy(SortOption.PRICE_LOW_TO_HIGH);

        int countAfter = getProductPage().getProductPrices().size();
        Assert.assertEquals(countAfter, countBefore, "Number of products changed after sort.");
    }
}
