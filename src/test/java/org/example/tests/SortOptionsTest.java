package org.example.tests;

import org.example.enums.SortOption;
import org.example.enums.UserCredentials;
import org.example.pages.LoginPageBase;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortOptionsTest extends BaseTest {

    private static final int MIN_SORTABLE_ITEMS = 2;
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;

    private ProductPageBase productPage;

    @BeforeMethod
    public void login() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        productPage = loginPage.login(UserCredentials.STANDARD_USER);
    }

    @Test
    public void testSortOptions() {
        SoftAssert softAssert = new SoftAssert();

        for (SortOption option : SortOption.values()) {
            productPage.sortBy(option);
            productPage.waitForProductsToBePresent();

            switch (option) {
                case PRICE_LOW_TO_HIGH -> verifyPricesSorted(softAssert, true);
                case PRICE_HIGH_TO_LOW -> verifyPricesSorted(softAssert, false);
                case NAME_A_TO_Z -> verifyNamesSorted(softAssert, true);
                case NAME_Z_TO_A -> verifyNamesSorted(softAssert, false);
            }
        }

        softAssert.assertAll();
    }

    private void verifyPricesSorted(SoftAssert softAssert, boolean ascending) {
        List<Double> prices = productPage.getDisplayedPrices();
        if (prices.size() < MIN_SORTABLE_ITEMS) {
            softAssert.fail("Too few prices to validate.");
            return;
        }

        double first = prices.get(FIRST_INDEX);
        double second = prices.get(SECOND_INDEX);

        if (ascending) {
            softAssert.assertTrue(first <= second, "Prices not sorted low to high.");
        } else {
            softAssert.assertTrue(first >= second, "Prices not sorted high to low.");
        }
    }

    private void verifyNamesSorted(SoftAssert softAssert, boolean ascending) {
        List<String> actualNames = productPage.getDisplayedProductNames();
        if (actualNames.size() < MIN_SORTABLE_ITEMS) {
            softAssert.fail("Too few names to validate.");
            return;
        }

        List<String> expected = new ArrayList<>(actualNames);
        if (ascending) {
            expected.sort(String::compareToIgnoreCase);
        } else {
            expected.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        }

        softAssert.assertEquals(actualNames, expected, "Names not sorted " + (ascending ? "A to Z" : "Z to A"));
    }
}


