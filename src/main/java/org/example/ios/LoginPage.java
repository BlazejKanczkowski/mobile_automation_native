//package org.example.ios;
//
//import com.zebrunner.carina.utils.factory.DeviceType;
//import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
//import org.example.enums.UserType;
//import org.example.pages.LoginPageBase;
//import org.example.pages.ProductListPageBase;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.FindBy;
//
//@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
//public class LoginPage extends LoginPageBase {
//
//    @FindBy(xpath = "//XCUIElementTypeTextField[@name='test-Username']")
//    private ExtendedWebElement usernameField;
//
//    @FindBy(xpath = "//XCUIElementTypeSecureTextField[@name='test-Password']")
//    private ExtendedWebElement passwordField;
//
//    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-LOGIN']")
//    private ExtendedWebElement loginButton;
//
//    public LoginPage(WebDriver driver) {
//        super(driver);
//    }
//
//    @Override
//    public ProductListPageBase login(UserType user) {
//        return login(user.getUsername(), user.getPassword());
//    }
//
//    @Override
//    public ProductListPageBase login(String username, String password) {
//        usernameField.type(username);
//        passwordField.type(password);
//        loginButton.click();
//        return initPage(getDriver(), ProductListPageBase.class);
//    }
//
//    @Override
//    public boolean isLoginButtonDisplayed() {
//        return loginButton.isElementPresent();
//    }
//
//    @Override
//    public boolean isPageOpened() {
//        return loginButton.isElementPresent();
//    }
//}
