package org.example.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.android.components.FilterComponent;
import org.example.android.components.ProductListItemComponent;
import org.example.android.components.TopMainMenuComponent;
import org.example.enums.SortOption;
import org.example.pages.CartPageBase;
import org.example.pages.ProductPageBase;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductListPage extends ProductPageBase implements IMobileUtils {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/..")
    private TopMainMenuComponent topMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private ExtendedWebElement pageTitle;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, 'test-Item')]")
    private List<ProductListItemComponent> productItems;

    @AndroidFindBy(xpath = "//android.widget.ScrollView//android.widget.TextView[contains(@text, '.')]")
    private ExtendedWebElement detailsDescription;

    @AndroidFindBy(accessibility = "test-Toggle")
    private ExtendedWebElement switchViewButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Modal Selector Button']")
    private FilterComponent filter;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='test-Item title']")
    private List<ExtendedWebElement> productNames;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc='test-Item title'])[1]")
    private ExtendedWebElement firstProductTitle;

    public ProductListPage(WebDriver driver) {
        super(driver);
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
    }

    @Override
    public List<String> getDisplayedProductNames() {
        return productItems.stream()
                .map(ProductListItemComponent::getItemName)
                .collect(Collectors.toList());
    }

    @Override
    public List<Double> getDisplayedPrices() {
        return productItems.stream()
                .map(ProductListItemComponent::getItemPrice)
                .collect(Collectors.toList());
    }

    @Override
    public void addProductToCartByName(String productName) {
        productItems.stream()
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
    public void openProductDetailsByName(String productName) {
        productItems.stream()
                .filter(product -> product.getItemName().equalsIgnoreCase(productName))
                .findFirst()
                .ifPresent(ProductListItemComponent::clickItemName);
    }

    @Override
    public boolean isDetailsPageOpened() {
        return detailsDescription.isElementPresent();
    }

    @Override
    public CartPageBase clickCartIcon() {
        topMenu.clickCartIcon();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public int getCartCount() {
        return topMenu.getCartCount();
    }

    private String normalize(String name) {
        return name.trim().toLowerCase();
    }

    @Override
    public void waitForProductsToBePresent() {
        waitUntilElementPresent(firstProductTitle, Duration.ofSeconds(5));
    }
}
