package org.example.pages;

import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends BasePage {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isCheckoutButtonPresent();

    public abstract CheckoutPageBase clickCheckout();

    public abstract boolean isPageOpen();

    public abstract void scrollToCheckoutButton();

    public abstract boolean checkIfVisibleInCart(String product);

}
