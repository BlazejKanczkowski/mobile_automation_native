package org.example.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.example.enums.UserType;
import org.example.pages.LoginPageBase;
import org.example.pages.ProductPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @ExtendedFindBy(accessibilityId = "test-Username")
    private ExtendedWebElement usernameField;

    @ExtendedFindBy(accessibilityId = "test-Password")
    private ExtendedWebElement passwordField;

    @ExtendedFindBy(accessibilityId = "test-LOGIN")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductPageBase login(UserType user) {
        return login(user.getUsername(), user.getPassword());
    }

    @Override
    public ProductPageBase login(String username, String password) {
        usernameField.waitUntil(ExpectedConditions.visibilityOf(usernameField.getElement()), 5);
        usernameField.type(username);
        passwordField.type(password);
        loginButton.click();
        return initPage(getDriver(), ProductPageBase.class);
    }

    @Override
    public boolean isLoginButtonDisplayed() {
        return loginButton.isElementPresent();
    }

    @Override
    public boolean isPageOpened() {
        return loginButton.isElementPresent();
    }
}
