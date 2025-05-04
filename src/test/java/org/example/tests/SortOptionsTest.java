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

            if (option == SortOption.PRICE_LOW_TO_HIGH || option == SortOption.PRICE_HIGH_TO_LOW) {
                List<Double> actualPrices = productPage.getDisplayedPrices();
                Assert.assertFalse(actualPrices.isEmpty(), "Prices not visible after sorting: " + option);

                List<Double> expectedPrices = new ArrayList<>(actualPrices);
                if (option == SortOption.PRICE_LOW_TO_HIGH) {
                    expectedPrices.sort(Double::compareTo);
                } else {
                    expectedPrices.sort(Collections.reverseOrder());
                }

                System.out.println("[DEBUG] Prices actual:   " + actualPrices);
                System.out.println("[DEBUG] Prices expected: " + expectedPrices);

                Assert.assertEquals(actualPrices, expectedPrices, "Prices not sorted correctly for: " + option);

            } else if (option == SortOption.NAME_A_TO_Z || option == SortOption.NAME_Z_TO_A) {
                List<String> actualNames = productPage.getDisplayedProductNames();
                Assert.assertFalse(actualNames.isEmpty(), "Product names list is empty after sorting: " + option);

                List<String> expectedNames = new ArrayList<>(actualNames);
                if (option == SortOption.NAME_A_TO_Z) {
                    expectedNames.sort(String::compareToIgnoreCase);
                } else {
                    expectedNames.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
                }

                System.out.println("[DEBUG] Names actual:   " + actualNames);
                System.out.println("[DEBUG] Names expected: " + expectedNames);

                Assert.assertEquals(actualNames, expectedNames, "Names not sorted correctly for: " + option);
            }
        }
    }
}