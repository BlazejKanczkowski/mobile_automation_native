package org.example.tests;

import org.example.enums.SortOption;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ItemCountTest extends BaseTest {

    @Test
    public void testProductCountUnchangedAfterSortByPrice() {

        loginToAccount();
        Assert.assertTrue(getProductPage().isProductListVisible(), "Product list not visible.");

        int productCountBeforeSort = getProductPage().getProductPrices().size();
        getProductPage().sortBy(SortOption.PRICE_LOW_TO_HIGH);

        int productCountAfter = getProductPage().getProductPrices().size();
        Assert.assertEquals(productCountAfter, productCountBeforeSort, "The number of products should remain the same after sorting");
    }
}
