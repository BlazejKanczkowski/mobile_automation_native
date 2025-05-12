package org.example.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.example.pages.DrawingPageBase;
import org.openqa.selenium.WebDriver;

import static com.zebrunner.carina.webdriver.gui.mobile.devices.MobileAbstractPage.SWIPE_DURATION;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DrawingPageBase.class)
public class DrawingPage extends DrawingPageBase implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-SAVE")
    private ExtendedWebElement saveButton;

    @ExtendedFindBy(image = "line.png")
    private ExtendedWebElement drawSquare;

    public DrawingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void drawLine() {
        int width = getDriver().manage().window().getSize().getWidth();
        int height = getDriver().manage().window().getSize().getHeight();

        int x = width / 8;
        int centerY = height / 2;
        int offset = height / 12;
        int startY = centerY + offset;
        int endY = centerY - offset;

        swipe(x, startY, x, endY, 500);
    }

    @Override
    public boolean isCanvasVisible() {
        return saveButton.isElementPresent();
    }

    @Override
    public boolean isShapeVisible() {
        return drawSquare.isElementPresent();
    }
}
