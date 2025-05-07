package org.example.ios.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopMainMenuComponent extends AbstractUIObject {

    @FindBy(xpath = "//XCUIElementTypeButton[@name='test-Cart']")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Cart']//XCUIElementTypeStaticText")
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
