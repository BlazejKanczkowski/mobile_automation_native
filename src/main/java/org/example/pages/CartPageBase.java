package org.example.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import java.util.List;


public abstract class CartPageBase extends BasePage {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCheckoutButtonPresent();

    public abstract CheckoutPageBase clickCheckout();

    public abstract boolean isPageOpen();

    public abstract void scrollToCheckoutButton();

}
