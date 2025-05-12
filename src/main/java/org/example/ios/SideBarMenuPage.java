package org.example.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.example.pages.SideBarMenuPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = SideBarMenuPageBase.class)
public class SideBarMenuPage extends SideBarMenuPageBase {

    @ExtendedFindBy(accessibilityId = "test-Menu")
    private ExtendedWebElement menuButton;

    @ExtendedFindBy(accessibilityId = "test-ABOUT")
    private ExtendedWebElement aboutOption;

    @ExtendedFindBy(accessibilityId = "test-LOGOUT")
    private ExtendedWebElement logoutOption;

    @ExtendedFindBy(accessibilityId = "test-DRAWING")
    private ExtendedWebElement drawingOption;

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
    public void openDrawingPage() {
        menuButton.click();
        drawingOption.click();
    }

    @Override
    public boolean isPageOpened() {
        return menuButton.isElementPresent();
    }
}

