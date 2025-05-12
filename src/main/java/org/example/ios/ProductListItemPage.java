package org.example.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.example.components.TopMainMenuComponentBase;
import org.example.ios.components.FilterComponent;
import org.example.ios.components.ProductListItemComponent;
import org.example.enums.SortOption;
import org.example.ios.components.TopMainMenuComponent;
import org.example.pages.CartPageBase;
import org.example.pages.ProductListPageBase;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.utils.WaitUtil.waitUntilElementPresent;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductListPageBase.class)
public class ProductListItemPage extends ProductListPageBase implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-PRODUCTS")
    private ExtendedWebElement pageTitle;

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

    @ExtendedFindBy(accessibilityId = "test-Item")
    private List<ProductListItemComponent> productListItemComponents;

    public ProductListItemPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void removeProductFromCartByName(String productName) {
        for (ProductListItemComponent product : productListItemComponents) {
            if (product.getItemName().equalsIgnoreCase(productName)) {
                product.clickRemoveFromCart();
                break;
            }
        }
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
        return productListItemComponents.stream()
                .map(ProductListItemComponent::getItemName)
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getProductPrices() {
        return productListItemComponents.stream()
                .map(ProductListItemComponent::getItemPrice)
                .collect(Collectors.toList());
    }

    @Override
    public void addProductToCartByName(String productName) {
        for (ProductListItemComponent product : productListItemComponents) {
            if (normalize(product.getItemName()).contains(normalize(productName))) {
                product.clickAddToCart();
                break;
            }
        }
    }

    @Override
    public void addProductsToCart(List<String> names) {
        for (String name : names) {
            addProductToCartByName(name);
        }
    }

    @Override
    public void openProductByName(String productName) {
        waitForProductsToBePresent();
        productListItemComponents.stream()
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
        getTopMainMenu().clickCartIcon();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public int getCartCount() {
        return getTopMainMenu().getCartItemCount();
    }

    private String normalize(String name) {
        return name.trim().toLowerCase();
    }

    private static final Duration PRODUCT_WAIT_TIMEOUT = Duration.ofSeconds(5);

    @Override
    public void waitForProductsToBePresent() {
        waitUntilElementPresent(firstProductTitle, PRODUCT_WAIT_TIMEOUT);
    }

    @Override
    public TopMainMenuComponentBase getTopMainMenu() {
        return topMenu;
    }
}