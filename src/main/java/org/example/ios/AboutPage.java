package org.example.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.example.pages.AboutPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = AboutPageBase.class)
public class AboutPage extends AboutPageBase implements IMobileUtils {

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Sign up for free']")
    private ExtendedWebElement signUpButton;

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isSignUpButtonPresent() {
        return signUpButton.isElementPresent(3);
    }
}
