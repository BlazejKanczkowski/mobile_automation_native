package org.example.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.pages.MenuPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"test-Menu\")")
    private ExtendedWebElement menuButton;

    @AndroidFindBy(accessibility = "test-ABOUT")
    private ExtendedWebElement aboutOption;

    @AndroidFindBy(accessibility = "test-LOGOUT")
    private ExtendedWebElement logoutOption;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openAboutPage() {
        menuButton.click();
        aboutOption.click();
    }

    @Override
    public void logout() {
        menuButton.click();
        logoutOption.clickIfPresent();
    }
}
