package org.example.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.ios.components.ProductListItemComponent;
import org.example.enums.SortOption;
import org.example.pages.CartPageBase;
import org.example.pages.ProductPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageBase.class)
public class ProductPage extends ProductPageBase implements IMobileUtils {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Cart']")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Cart']/XCUIElementTypeOther")
    private List<ExtendedWebElement> cartBadgeElements;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Modal Selector Button']")
    private ExtendedWebElement sortDropdown;

    @FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Name') or contains(@name, 'Price')]")
    private List<ExtendedWebElement> sortOptions;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='PRODUCTS']")
    private ExtendedWebElement pageTitle;

    @FindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'test-Item')]")
    private List<ProductListItemComponent> productItems;

    @FindBy(xpath = "//XCUIElementTypeScrollView//XCUIElementTypeStaticText[contains(@name, '.')]")
    private ExtendedWebElement detailsDescription;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Toggle']")
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
        for (ExtendedWebElement opt : sortOptions) {
            if (opt.getText().equalsIgnoreCase(option.getVisibleText())) {
                opt.click();
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
        for (ProductListItemComponent item : productItems) {
            if (normalize(item.getItemName()).contains(normalize(productName))) {
                item.clickAddToCart();
                return;
            }
        }
        throw new RuntimeException("Product not found: " + productName);
    }

    @Override
    public CartPageBase clickCartIcon() {
        tap(cartIcon);
        CartPageBase cartPage = initPage(getDriver(), CartPageBase.class);

        if (!cartPage.isCheckoutButtonPresent()) {
            throw new RuntimeException("Cart page did not load after clicking cart icon.");
        }
        return cartPage;
    }


    @Override
    public int getCartCount() {
        for (ExtendedWebElement el : cartBadgeElements) {
            String text = el.getText();
            if (text != null && text.matches("\\d+")) {
                return Integer.parseInt(text);
            }
        }
        return 0;
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
        } else {
            throw new RuntimeException("Switch view button not found!");
        }
    }

    @Override
    public void openProductDetails(String productName) {
        for (ProductListItemComponent item : productItems) {
            if (normalize(item.getItemName()).equalsIgnoreCase(normalize(productName))) {
                item.clickItemName();
                return;
            }
        }
        throw new RuntimeException("Product not found: " + productName);
    }

    @Override
    public boolean isDetailsPageOpened() {
        return detailsDescription.isElementPresent();
    }

    private String normalize(String name) {
        return name.trim().toLowerCase();
    }
}
