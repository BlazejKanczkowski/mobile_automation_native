package org.example.tests;

import org.example.enums.SortOption;
import org.example.enums.UserCredentials;
import org.example.pages.LoginPageBase;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortOptionsTest extends BaseTest {

    @Test
    public void testAllSortOptions() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        ProductPageBase productPage = loginPage.login(UserCredentials.STANDARD_USER);

        for (SortOption option : SortOption.values()) {
            productPage.sortBy(option);
            List<Double> prices = productPage.getDisplayedPrices();

            Assert.assertFalse(prices.isEmpty(), "Prices not visible after sorting: " + option);

            if (option == SortOption.PRICE_LOW_TO_HIGH || option == SortOption.PRICE_HIGH_TO_LOW) {
                List<Double> expected = new ArrayList<>(prices);
                if (option == SortOption.PRICE_LOW_TO_HIGH) {
                    expected.sort(Double::compareTo);
                } else {
                    expected.sort(Collections.reverseOrder());
                }
                Assert.assertEquals(prices, expected, "Prices not sorted correctly for: " + option);
            }
        }
    }

}
