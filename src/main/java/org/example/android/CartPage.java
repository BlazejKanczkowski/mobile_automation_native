package org.example.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.pages.CartPageBase;
import org.example.pages.CheckoutPageBase;
import org.example.utils.MobileScrollUtil;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CHECKOUT']")
    private ExtendedWebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isCheckoutButtonPresent() {
        return checkoutButton.isElementPresent();
    }

    @Override
    public CheckoutPageBase clickCheckout() {
        int maxScrolls = 3;
        int scrollCount = 0;

        while (!checkoutButton.isVisible() && scrollCount < maxScrolls) {
            MobileScrollUtil.scrollDownMultipleTimes((AppiumDriver) getDriver(), 1);
            scrollCount++;
        }

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
}
