package org.example.android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ProductListItemComponent extends AbstractUIObject {

    @AndroidFindBy(xpath = ".//*[@content-desc='test-Item title']")
    private ExtendedWebElement itemName;

    @AndroidFindBy(accessibility = "test-Price")
    private ExtendedWebElement price;

    @AndroidFindBy(accessibility = "test-ADD TO CART")
    private ExtendedWebElement addToCartButton;

    @AndroidFindBy(accessibility = "test-REMOVE")
    private ExtendedWebElement removeButton;

    public ProductListItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public double getItemPrice() {
        if (!price.isElementPresent()) {
            return -1.0;
        }

        String text = price.getText();
        return Double.parseDouble(text.replace("$", "").trim());
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public void clickItemName() {
        itemName.click();
    }

    public void clickRemoveFromCart() {
        if (removeButton.isElementPresent()) {
            removeButton.click();
        }
    }
}