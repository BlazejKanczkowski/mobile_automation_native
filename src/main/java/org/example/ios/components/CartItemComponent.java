package org.example.ios.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartItemComponent extends AbstractUIObject{

    @FindBy(xpath = ".//XCUIElementTypeOther[@name='test-Description']//XCUIElementTypeStaticText")
    private List<ExtendedWebElement> titleElements;

    public CartItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductTitle() {
        return titleElements.get(0).getText().trim();
    }
}