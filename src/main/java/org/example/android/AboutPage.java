package org.example.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.pages.AboutPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AboutPageBase.class)
public class AboutPage extends AboutPageBase {

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Sign up for free']")
    private ExtendedWebElement signUpButton;

    public AboutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignUpButtonPresent() {
        return signUpButton.isElementPresent(3);
    }
}
