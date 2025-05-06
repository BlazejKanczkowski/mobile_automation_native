package org.example.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.pages.MenuPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MenuPageBase.class)
public class MenuPage extends MenuPageBase {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']/android.view.ViewGroup/android.widget.ImageView")
    private ExtendedWebElement menuButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-ABOUT']")
    private ExtendedWebElement aboutOption;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGOUT']")
    private ExtendedWebElement logoutOption;

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    private void openMenuIfNeeded() {
        if (!aboutOption.isElementPresent() || !logoutOption.isElementPresent()) {
            menuButton.click();
        }
    }

    @Override
    public void openAboutPage() {
        openMenuIfNeeded();
        aboutOption.click();
    }

    @Override
    public void logout() {
        openMenuIfNeeded();
        logoutOption.click();
    }
}
