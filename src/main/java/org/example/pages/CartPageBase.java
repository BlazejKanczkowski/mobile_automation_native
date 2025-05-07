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

    public abstract ExtendedWebElement getCheckoutButton();

    public abstract void scrollToCheckoutButton();

    public abstract List<Double> getProductPrices();

    public abstract double getTotalPrice();


}
