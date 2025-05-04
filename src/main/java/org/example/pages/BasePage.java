package org.example.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public abstract class BasePage extends AbstractPage {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public void waitForVisibility(ExtendedWebElement element) {
        element.waitUntil(ExpectedConditions.visibilityOf(element.getElement()), Duration.ofSeconds(3));
    }

    public boolean isElementVisible(ExtendedWebElement element) {
        return element.isElementPresent() && element.isVisible();
    }

    public void clickIfVisible(ExtendedWebElement element) {
        if (isElementVisible(element)) {
            element.click();
        }
    }
    public void waitUntilPresent(ExtendedWebElement element, Duration timeout) {
        element.waitUntil(ExpectedConditions.presenceOfElementLocated(element.getBy()), timeout);
    }

}
