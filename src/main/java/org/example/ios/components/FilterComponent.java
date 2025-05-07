package org.example.ios.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.example.enums.SortOption;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FilterComponent extends AbstractUIObject {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-Modal Selector Button']//XCUIElementTypeImage")
    private ExtendedWebElement sortDropdown;

    public FilterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void sortBy(SortOption option) {
        sortDropdown.click();

        String optionLocator = String.format(
                "//XCUIElementTypeScrollView[@name='Selector container']//XCUIElementTypeStaticText[@name='%s']",
                option.getVisibleText()
        );

        By by = By.xpath(optionLocator);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        WebElement rawElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        ExtendedWebElement optionElement = new ExtendedWebElement(rawElement, option.getVisibleText(), by);

        optionElement.click();
    }
}
