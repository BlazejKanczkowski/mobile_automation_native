//package org.example.ios;
//
//import com.zebrunner.carina.utils.factory.DeviceType;
//import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
//import org.example.pages.LoginPageBase;
//import org.example.pages.ProductPageBase;
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
//    @FindBy(xpath = "//XCUIElementTypeButton[@name='test-LOGIN']")
//    private ExtendedWebElement loginBtn;
//
//    public LoginPage(WebDriver driver) {
//        super(driver);
//    }
//
//    @Override
//    public void typeUsername(String username) {
//        usernameField.type(username);
//    }
//
//    @Override
//    public void typePassword(String password) {
//        passwordField.type(password);
//    }
//
//    @Override
//    public ProductPageBase clickLoginBtn() {
//        loginBtn.click();
//        return initPage(getDriver(), ProductPageBase.class);
//    }
//
//    @Override
//    public boolean isPageOpen() {
//        return usernameField.isElementPresent();
//    }
//}
