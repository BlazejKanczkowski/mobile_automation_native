package org.example.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.android.components.ProductListItemComponent;
import org.example.enums.SortOption;
import org.example.pages.CartPageBase;
import org.example.pages.ProductPageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='PRODUCTS']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.TextView")
    private ExtendedWebElement cartBadge;

    @FindBy(xpath = "//android.widget.Spinner[@content-desc='test-Modal Selector']")
    private ExtendedWebElement sortDropdown;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    private List<ProductListItemComponent> productItems;

    @FindBy(xpath = "//android.widget.CheckedTextView")
    private List<ExtendedWebElement> sortOptions;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return pageTitle.isElementPresent();
    }

    @Override
    public boolean isProductListVisible() {
        return pageTitle.isElementPresent();
    }

    @Override
    public void sortBy(SortOption option) {
        sortDropdown.click();

        for (ExtendedWebElement opt : sortOptions) {
            if (opt.getText().equalsIgnoreCase(option.getVisibleText())) {
                opt.click();
                return;
            }
        }

        throw new RuntimeException("Sort option not found: " + option.getVisibleText());
    }

    @Override
    public CartPageBase clickCartIcon() {
        cartIcon.click();
        return initPage(getDriver(), CartPageBase.class);
    }

    @Override
    public int getCartCount() {
        if (cartBadge.isElementPresent()) {
            return Integer.parseInt(cartBadge.getText());
        } else {
            return 0;
        }
    }

    @Override
    public List<Double> getDisplayedPrices() {
        return productItems.stream()
                .map(ProductListItemComponent::getItemPrice)
                .collect(Collectors.toList());
    }

    @Override
    public void addProductToCartByName(String productName) {
        for (ProductListItemComponent product : productItems) {
            if (product.getItemName().equalsIgnoreCase(productName)) {
                product.clickAddToCart();
                break;
            }
        }
    }

    @Override
    public void addProductsToCart(List<String> productNames) {
        for (String name : productNames) {
            addProductToCartByName(name);
        }
    }
}
