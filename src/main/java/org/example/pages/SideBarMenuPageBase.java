package org.example.pages;

import org.openqa.selenium.WebDriver;

public abstract class SideBarMenuPageBase extends BasePage {

    public SideBarMenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void openAboutPage();

    public abstract void logout();

    public abstract void openDrawingPage();

    @Override
    public boolean isPageOpened() {
        return true;
    }
}
