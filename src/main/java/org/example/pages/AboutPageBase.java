package org.example.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AboutPageBase extends AbstractPage {

    public AboutPageBase(WebDriver driver){
        super(driver);
    }

    public abstract boolean isSignUpButtonPresent();
}
