package org.example.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.example.android.components.FilterComponent;
import org.example.android.components.ProductDetailsComponent;
import org.example.android.components.ProductListItemComponent;
import org.example.android.components.TopMainMenuComponent;
import org.example.components.ProductDetailsComponentBase;
import org.example.components.TopMainMenuComponentBase;
import org.example.enums.SortOption;
import org.example.pages.CartPageBase;
import org.example.pages.ProductPageBase;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.utils.WaitUtil.waitUntilElementPresent;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductListPage extends ProductPageBase implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-PRODUCTS")
    private ExtendedWebElement pageTitle;

    @ExtendedFindBy(accessibilityId = "test-Item")
    private List<ProductListItemComponent> productListItems;

    @ExtendedFindBy(accessibilityId = "test-BACK TO PRODUCTS")
    private ExtendedWebElement backToProductsButton;

    @ExtendedFindBy(accessibilityId = "test-Toggle")
    private ExtendedWebElement switchViewButton;

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    private FilterComponent filter;

    @ExtendedFindBy(accessibilityId = "test-Item title")
    private ExtendedWebElement firstProductTitle;

    @ExtendedFindBy(accessibilityId = "test-Cart")
    private TopMainMenuComponent topMenu;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void removeProductFromCartByName(String productName) {
        for (ProductListItemComponent product : productListItems) {
            if (product.getItemName().equalsIgnoreCase(productName)) {
                product.clickRemoveFromCart();
                break;
            }
        }
    }

    @Override
    public ProductDetailsComponentBase getProductDetails() {
        return new ProductDetailsComponent(getDriver());
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.isElementPresent();
    }

    @Override
    public boolean isProductListVisible() {
        return isPageOpened();
    }

    @Override
    public void sortBy(SortOption option) {
        filter.sortBy(option);
        waitForProductsToBePresent();
    }

    @Override
    public List<String> getDisplayedProductNames() {
        return productListItems.stream()
                .map(ProductListItemComponent::getItemName)
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getProductPrices() {
        return productListItems.stream()
                .map(ProductListItemComponent::getItemPrice)
                .collect(Collectors.toList());
    }

    @Override
    public void addProductToCartByName(String productName) {
        productListItems.stream()
                .filter(product -> normalize(product.getItemName()).contains(normalize(productName)))
                .findFirst()
                .ifPresent(ProductListItemComponent::clickAddToCart);
    }

    @Override
    public void addProductsToCart(List<String> names) {
        names.forEach(this::addProductToCartByName);
    }

    @Override
    public void switchView() {
        if (switchViewButton.isElementPresent()) {
            switchViewButton.click();
        } else {
            throw new RuntimeException("Switch view button not found!");
        }
    }

    @Override
    public void openProductByName(String productName) {
        waitForProductsToBePresent();
        productListItems.stream()
                .filter(product -> product.getItemName().equalsIgnoreCase(productName))
                .findFirst()
                .ifPresent(ProductListItemComponent::clickItemName);
    }

    @Override
    public boolean isDetailsPageOpened() {
        return backToProductsButton.isElementPresent();
    }

    @Override
    public CartPageBase clickCartIcon() {
        topMenu.clickCartIcon();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public int getCartCount() {
        return topMenu.getCartItemCount();
    }

    private String normalize(String name) {
        return name.trim().toLowerCase();
    }

    @Override
    public void waitForProductsToBePresent() {
        waitUntilElementPresent(firstProductTitle, Duration.ofSeconds(5));
    }

    @Override
    public TopMainMenuComponentBase getTopMainMenu() {
        return topMenu;
    }
}
