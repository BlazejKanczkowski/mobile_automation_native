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

    @AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@content-desc, 'test-Item')]")
    private List<ProductListItemComponent> productItems;

    @AndroidFindBy(xpath = "//android.widget.ScrollView//android.widget.TextView[contains(@text, '.')]")
    private ExtendedWebElement detailsDescription;

    @AndroidFindBy(accessibility = "test-Toggle")
    private ExtendedWebElement switchViewButton;


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
                .filter(p -> normalize(p.getItemName()).contains(normalize(productName)))
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
        for (String name : names) {
            addProductToCartByName(name);
        }
    }

    @Override
    public void switchView() {
        if (switchViewButton.isElementPresent()) {
            switchViewButton.click();
            pause(1);
        } else {
            throw new RuntimeException("Switch view button not found!");
        }
    }

    @Override
    public void openProductDetails(String productName) {
        productItems.stream()
                .filter(p -> p.getItemName().equalsIgnoreCase(productName))
                .findFirst()
                .ifPresent(item -> {
                    item.clickItemName();
                    pause(1);
                });
    }

    @Override
    public boolean isDetailsPageOpened() {
        return detailsDescription.isElementPresent();
    }

    private String normalize(String name) {
        return name.trim().toLowerCase();
    }
}
