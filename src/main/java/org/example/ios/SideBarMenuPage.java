package org.example.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.pages.SideBarMenuPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SideBarMenuPageBase.class)
public class SideBarMenuPage extends SideBarMenuPageBase {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Menu']")
    private ExtendedWebElement menuButton;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-ABOUT']")
    private ExtendedWebElement aboutOption;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-LOGOUT']")
    private ExtendedWebElement logoutOption;

    public SideBarMenuPage(WebDriver driver) {
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
