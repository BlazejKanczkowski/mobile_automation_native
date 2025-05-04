package org.example.pages;

import org.example.enums.SortOption;
import org.openqa.selenium.WebDriver;
import java.util.List;

public abstract class ProductPageBase extends BasePage {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductListVisible();

    public abstract void sortBy(SortOption option);

    public abstract CartPageBase clickCartIcon();

    public abstract int getCartCount();

    public abstract List<Double> getDisplayedPrices();

    public abstract void addProductToCartByName(String productName);

    public abstract void addProductsToCart(List<String> productNames);

    public abstract List<String> getDisplayedProductNames();

    public abstract void switchView();

    public abstract void openProductDetails(String productName);

    public abstract boolean isDetailsPageOpened();
}
