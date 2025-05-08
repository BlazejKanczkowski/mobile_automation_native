package org.example.pages;

import org.example.enums.UserType;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends BasePage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductListPageBase login(UserType userType, boolean useAutoFilling);

    public abstract boolean isLoginButtonDisplayed();

}
