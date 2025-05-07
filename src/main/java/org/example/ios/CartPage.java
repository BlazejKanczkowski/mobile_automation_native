package org.example.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.pages.CartPageBase;
import org.example.pages.CheckoutPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;


@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase implements IMobileUtils {

    @FindBy(xpath = "//XCUIElementTypeButton[@name='test-CHECKOUT']")
    private ExtendedWebElement checkoutButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, '$')]")
    private List<ExtendedWebElement> productPrices;

    @FindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'Total')]")
    private ExtendedWebElement totalPrice;


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<Double> getProductPrices() {
        return productPrices.stream()
                .map(ExtendedWebElement::getText)
                .map(text -> text.replace("$", "").trim())
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    @Override
    public double getTotalPrice() {
        String text = totalPrice.getText().replace("Total: $", "").trim();
        return Double.parseDouble(text);
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
