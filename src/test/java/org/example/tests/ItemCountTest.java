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
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductPageBase productPage = loginPage.login(UserCredentials.STANDARD_USER);
        Assert.assertTrue(productPage.isProductListVisible(), "Product list not visible.");

        int countBefore = productPage.getDisplayedPrices().size();

        productPage.sortBy(SortOption.PRICE_LOW_TO_HIGH);

        int countAfter = productPage.getDisplayedPrices().size();

        Assert.assertEquals(countAfter, countBefore, "Number of products changed after sort.");
    }
    //DONE
}
