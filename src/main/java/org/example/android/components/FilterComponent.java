package org.example.android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.enums.SortOption;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class FilterComponent extends AbstractUIObject {

    @ExtendedFindBy(accessibilityId = "test-Modal Selector Button")
    private ExtendedWebElement sortDropdown;

    public FilterComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void sortBy(SortOption option) {
        sortDropdown.click();

        String optionLocator = String.format(
                "//android.widget.ScrollView[@content-desc='Selector container']//android.widget.TextView[@text='%s']",
                option.getVisibleText()
        );

        By by = By.xpath(optionLocator);

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        WebElement rawElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        ExtendedWebElement optionElement = new ExtendedWebElement(rawElement, option.getVisibleText(), by);

        optionElement.click();
    }
}
