package org.example.tests;

import org.example.enums.SortOption;
import org.example.enums.UserCredentials;
import org.example.pages.LoginPageBase;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortOptionsTest extends BaseTest {

    private ProductPageBase productPage;

    @BeforeMethod
    public void login() {
        LoginPageBase loginPage = initPage(getDriver(), LoginPageBase.class);
        productPage = loginPage.login(UserCredentials.STANDARD_USER);
        Assert.assertTrue(productPage.isProductListVisible(), "Product page not visible after login.");
    }

    @Test
    public void testPriceSortingLowToHigh() {
        productPage.sortBy(SortOption.PRICE_LOW_TO_HIGH);
        verifyTwoPricesSortedCorrectly(true);
    }

    @Test
    public void testPriceSortingHighToLow() {
        productPage.sortBy(SortOption.PRICE_HIGH_TO_LOW);
        verifyTwoPricesSortedCorrectly(false);
    }

    @Test
    public void testNameSortingAToZ() {
        productPage.sortBy(SortOption.NAME_A_TO_Z);
        verifyAllNamesSortedCorrectly(true);
    }

    @Test
    public void testNameSortingZToA() {
        productPage.sortBy(SortOption.NAME_Z_TO_A);
        verifyAllNamesSortedCorrectly(false);
    }

    private void verifyTwoPricesSortedCorrectly(boolean ascending) {
        List<Double> actualPrices = productPage.getDisplayedPrices();
        Assert.assertTrue(actualPrices.size() >= 2, "Too few prices to compare.");

        double first = actualPrices.get(0);
        double second = actualPrices.get(1);

        if (ascending) {
            Assert.assertTrue(first <= second, "Prices not in ascending order.");
        } else {
            Assert.assertTrue(first >= second, "Prices not in descending order.");
        }
    }

    private void verifyAllNamesSortedCorrectly(boolean ascending) {
        List<String> actualNames = productPage.getDisplayedProductNames();
        Assert.assertFalse(actualNames.isEmpty(), "Product names are empty.");

        List<String> expected = new ArrayList<>(actualNames);
        if (ascending) {
            expected.sort(String::compareToIgnoreCase);
        } else {
            expected.sort(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        }

        Assert.assertEquals(actualNames, expected, "Names not sorted correctly.");
    }
}
