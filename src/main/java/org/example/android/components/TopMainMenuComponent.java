package org.example.android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class TopMainMenuComponent extends AbstractUIObject {

    @AndroidFindBy(accessibility = "test-Cart")
    private ExtendedWebElement cartIcon;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.TextView")
    private ExtendedWebElement cartBadge;

    public TopMainMenuComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void clickCartIcon() {
        cartIcon.click();
    }

    public boolean isCartBadgePresent() {
        return cartBadge.isElementPresent();
    }

    public int getCartCount() {
        return isCartBadgePresent() ? Integer.parseInt(cartBadge.getText()) : 0;
    }
}
