package org.example.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.example.pages.SideBarMenuPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SideBarMenuPageBase.class)
public class SideBarMenuPage extends SideBarMenuPageBase {

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private ExtendedWebElement menuButton;

    @ExtendedFindBy(accessibilityId = "test-ABOUT")
    private ExtendedWebElement aboutOption;

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    private ExtendedWebElement logoutOption;

    public SideBarMenuPage(WebDriver driver) {
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

    @Override
    public boolean isPageOpened() {
        return menuButton.isElementPresent();
    }
}
