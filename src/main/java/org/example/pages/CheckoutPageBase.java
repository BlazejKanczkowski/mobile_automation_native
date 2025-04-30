package org.example.pages;

import org.openqa.selenium.WebDriver;

public abstract class CheckoutPageBase extends BasePage {

    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void fillForm(String firstName, String lastName, String postalCode);

    public abstract void finishOrder();

    public abstract boolean isConfirmationDisplayed();
}
