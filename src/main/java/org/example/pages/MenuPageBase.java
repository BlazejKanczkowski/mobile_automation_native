package org.example.pages;

import org.openqa.selenium.WebDriver;

public abstract class MenuPageBase extends BasePage {

    public MenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void openAboutPage();

    public abstract void logout();
}
