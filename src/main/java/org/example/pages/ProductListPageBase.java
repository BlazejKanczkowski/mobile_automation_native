package org.example.pages;


import org.example.components.TopMainMenuComponentBase;
import org.example.enums.SortOption;
import org.openqa.selenium.WebDriver;
import java.util.List;

public abstract class ProductListPageBase extends BasePage {

    public ProductListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isProductListVisible();

    public abstract void sortBy(SortOption option);

    public abstract CartPageBase clickCartIcon();

    public abstract int getCartCount();

    public abstract List<Double> getProductPrices();

    public abstract void addProductToCartByName(String productName);

    public abstract void addProductsToCart(List<String> productNames);

    public abstract List<String> getDisplayedProductNames();

    public abstract void openProductByName(String productName);

    public abstract boolean isDetailsPageOpened();

    public abstract void waitForProductsToBePresent();

    public abstract TopMainMenuComponentBase getTopMainMenu();

    public abstract void removeProductFromCartByName(String productName);

}
