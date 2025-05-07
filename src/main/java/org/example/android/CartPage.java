package org.example.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.pages.CartPageBase;
import org.example.pages.CheckoutPageBase;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase implements IMobileUtils {

    @AndroidFindBy(accessibility = "test-CHECKOUT")
    private ExtendedWebElement checkoutButton;

    @AndroidFindBy(accessibility = "test-Price")
    private List<ExtendedWebElement> productPrices;

    @AndroidFindBy(uiAutomator = "new UiSelector().textStartsWith(\"Item total:\")")
    private ExtendedWebElement totalPrice;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<Double> getProductPrices() {
        return productPrices.stream()
                .map(ExtendedWebElement::getText)
                .filter(text -> text.startsWith("$"))
                .map(text -> text.replace("$", "").trim())
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    @Override
    public double getTotalPrice() {
        String text = totalPrice.getText();
        String amount = text.replace("Item total: $", "").trim();
        return Double.parseDouble(amount);
    }

    @Override
    public boolean isCheckoutButtonPresent() {
        return checkoutButton.isElementPresent();
    }

    @Override
    public CheckoutPageBase clickCheckout() {
        swipe(checkoutButton);
        checkoutButton.click();
        return initPage(getDriver(), CheckoutPageBase.class);
    }

    @Override
    public boolean isPageOpen() {
        return checkoutButton.isElementPresent();
    }

    @Override
    public ExtendedWebElement getCheckoutButton() {
        return checkoutButton;
    }

    @Override
    public void scrollToCheckoutButton() {
        swipe(checkoutButton);
    }
}
