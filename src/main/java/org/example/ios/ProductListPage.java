//package org.example.ios;
//
//import com.zebrunner.carina.utils.factory.DeviceType;
//import com.zebrunner.carina.utils.mobile.IMobileUtils;
//import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
//import org.example.android.components.ProductDetailsComponent;
//import org.example.components.ProductDetailsComponentBase;
//import org.example.components.TopMainMenuComponentBase;
//import org.example.ios.components.FilterComponent;
//import org.example.ios.components.ProductListItemComponent;
//import org.example.enums.SortOption;
//import org.example.ios.components.TopMainMenuComponent;
//import org.example.pages.CartPageBase;
//import org.example.pages.ProductPageBase;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.FindBy;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static org.example.utils.WaitUtil.waitUntilElementPresent;
//
//@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductPageBase.class)
//public class ProductListPage extends ProductPageBase implements IMobileUtils {
//
//    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Cart']")
//    private ExtendedWebElement cartIcon;
//
//    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Cart']/XCUIElementTypeOther")
//    private List<ExtendedWebElement> cartBadgeElements;
//
//    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Modal Selector Button']")
//    private ExtendedWebElement sortDropdown;
//
//    @FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Name') or contains(@name, 'Price')]")
//    private List<ExtendedWebElement> sortOptions;
//
//    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='PRODUCTS']")
//    private ExtendedWebElement pageTitle;
//
//    @FindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'test-Item')]")
//    private List<ProductListItemComponent> productListItems;
//
//    @FindBy(xpath = "//XCUIElementTypeScrollView//XCUIElementTypeStaticText[contains(@name, '.')]")
//    private ExtendedWebElement detailsDescription;
//
//    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Toggle']")
//    private ExtendedWebElement switchViewButton;
//
//    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='test-Item title']")
//    private List<ExtendedWebElement> productNames;
//
//    @FindBy(xpath = "(//XCUIElementTypeStaticText[@name='test-Item title'])[1]")
//    private ExtendedWebElement firstProductTitle;
//
//    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Cart']")
//    private TopMainMenuComponent topMenu;
//
//    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Modal Selector Button']")
//    private FilterComponent filter;
//
//    @FindBy(xpath = "//XCUIElementTypeScrollView")
//    private ProductDetailsComponent productDetails;
//
//    public ProductListPage(WebDriver driver) {
//        super(driver);
//    }
//
//    @Override
//    public boolean isPageOpened() {
//        return pageTitle.isElementPresent();
//    }
//
//    @Override
//    public boolean isProductListVisible() {
//        return isPageOpened();
//    }
//
//    @Override
//    public void sortBy(SortOption option) {
//        filter.sortBy(option);
//    }
//
//    @Override
//    public List<String> getDisplayedProductNames() {
//        return productListItems.stream()
//                .map(ProductListItemComponent::getItemName)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Double> getProductPrices() {
//        return productListItems.stream()
//                .map(ProductListItemComponent::getItemPrice)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public void addProductToCartByName(String productName) {
//        for (ProductListItemComponent item : productListItems) {
//            if (normalize(item.getItemName()).contains(normalize(productName))) {
//                item.clickAddToCart();
//                return;
//            }
//        }
//        throw new RuntimeException("Product not found: " + productName);
//    }
//
//    @Override
//    public CartPageBase clickCartIcon() {
//        cartIcon.click();
//        return initPage(getDriver(), CartPageBase.class);
//    }
//
//    @Override
//    public int getCartCount() {
//        return topMenu.getCartItemCount();
//    }
//
//    @Override
//    public void addProductsToCart(List<String> names) {
//        for (String name : names) {
//            addProductToCartByName(name);
//        }
//    }
//
//    @Override
//    public void switchView() {
//        if (switchViewButton.isElementPresent()) {
//            switchViewButton.click();
//        } else {
//            throw new RuntimeException("Switch view button not found!");
//        }
//    }
//
//    @Override
//    public void openProductDetailsByName(String productName) {
//        productListItems.stream()
//                .filter(p -> p.getItemName().equalsIgnoreCase(productName))
//                .findFirst()
//                .ifPresent(ProductListItemComponent::clickItemName);
//    }
//
//    @Override
//    public boolean isDetailsPageOpened() {
//        return detailsDescription.isElementPresent();
//    }
//
//    private String normalize(String name) {
//        return name.trim().toLowerCase();
//    }
//
//    @Override
//    public void waitForProductsToBePresent() {
//        waitUntilElementPresent(firstProductTitle, Duration.ofSeconds(5));
//    }
//
//    @Override
//    public TopMainMenuComponentBase getTopMainMenu() {
//        return topMenu;
//    }
//
//    @Override
//    public ProductDetailsComponentBase getProductDetails() {
//        return productDetails;
//    }
//}
