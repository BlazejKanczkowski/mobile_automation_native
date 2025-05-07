package org.example.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class TopMainMenuComponentBase extends AbstractUIObject {

    public TopMainMenuComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract int getCartItemCount();

    public abstract void clickCartIcon();
}
