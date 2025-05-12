package org.example.pages;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DrawingPageBase extends AbstractPage {

    public DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void drawLine();

    public abstract boolean isCanvasVisible();

    public abstract boolean isShapeVisible();
}
