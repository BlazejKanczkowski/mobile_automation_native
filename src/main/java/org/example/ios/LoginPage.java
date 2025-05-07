package org.example.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.enums.UserCredentials;
import org.example.pages.LoginPageBase;
import org.example.pages.ProductPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(xpath = "//XCUIElementTypeTextField[@name='test-Username']")
    private ExtendedWebElement usernameField;

    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@name='test-Password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-LOGIN']")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductPageBase login(UserCredentials user) {
        return login(user.getUsername(), user.getPassword());
    }

    @Override
    public ProductPageBase login(String username, String password) {
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
