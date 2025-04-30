package org.example.pages;

import org.example.enums.UserCredentials;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends BasePage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductPageBase login(UserCredentials user);

    public abstract ProductPageBase login(String username, String password);

    public abstract boolean isLoginButtonDisplayed();

}
