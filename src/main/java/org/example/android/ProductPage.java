package org.example.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.android.components.ProductListItemComponent;
import org.example.enums.SortOption;
import org.example.pages.CartPageBase;
import org.example.pages.ProductPageBase;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @AndroidFindBy(accessibility = "test-Cart")
    private ExtendedWebElement cartIcon;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.TextView")
    private ExtendedWebElement cartBadge;

    @AndroidFindBy(accessibility = "test-Modal Selector Button")
    private ExtendedWebElement sortDropdown;

    @AndroidFindBy(
            xpath = "//android.widget.ScrollView//android.widget.TextView[not(contains(@text,'Sort items')) and not(contains(@text,'Cancel'))]"
    )
    private List<ExtendedWebElement> sortOptions;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private ExtendedWebElement pageTitle;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ProductListItemComponent> productItems;

    public ProductPage(WebDriver driver) {
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
        sortDropdown.click();
        pause(1);
        for (ExtendedWebElement opt : sortOptions) {
            if (opt.getText().equalsIgnoreCase(option.getVisibleText())) {
                opt.click();
                pause(1);
                return;
            }
        }
        throw new RuntimeException("Sort option not found: " + option);
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
                .filter(p -> p.getItemName().equalsIgnoreCase(productName))
                .findFirst()
                .ifPresent(ProductListItemComponent::clickAddToCart);
    }

    @Override
    public CartPageBase clickCartIcon() {
        cartIcon.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public int getCartCount() {
        return cartBadge.isElementPresent() ? Integer.parseInt(cartBadge.getText()) : 0;
    }

    @Override
    public void addProductsToCart(List<String> names) {
        names.forEach(this::addProductToCartByName);
    }
}
