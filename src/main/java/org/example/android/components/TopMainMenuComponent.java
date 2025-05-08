package org.example.android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.components.TopMainMenuComponentBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class TopMainMenuComponent extends TopMainMenuComponentBase {

    @ExtendedFindBy(accessibilityId = "test-Cart")
    private ExtendedWebElement cartIcon;

    @ExtendedFindBy(accessibilityId = "test-Cart Badge")
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

    public int getCartItemCount() {
        return isCartBadgePresent() ? Integer.parseInt(cartBadge.getText()) : 0;
    }
}
