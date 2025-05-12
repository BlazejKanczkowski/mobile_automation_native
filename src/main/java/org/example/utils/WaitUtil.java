package org.example.utils;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public final class WaitUtil {
    public static void waitForVisibility(ExtendedWebElement element, Duration timeout) {
        element.waitUntil(ExpectedConditions.visibilityOf(element.getElement()), timeout);
    }

    public static boolean isElementVisible(ExtendedWebElement element) {
        return element.isElementPresent() && element.isVisible();
    }

    public static void clickIfVisible(ExtendedWebElement element) {
        if (isElementVisible(element)) {
            element.click();
        }
    }

    public static void waitUntilElementPresent(ExtendedWebElement element, Duration timeout) {
        element.waitUntil(ExpectedConditions.presenceOfElementLocated(element.getBy()), timeout);
    }
}
