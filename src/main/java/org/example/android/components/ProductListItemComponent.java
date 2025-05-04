package org.example.android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ProductListItemComponent extends AbstractUIObject {

    @AndroidFindBy(accessibility = "test-Item title")
    private ExtendedWebElement itemName;

    @AndroidFindBy(accessibility = "test-Price")
    private ExtendedWebElement price;

    @AndroidFindBy(accessibility = "test-ADD TO CART")
    private ExtendedWebElement addToCartButton;

    public ProductListItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public double getItemPrice() {
        if (!price.isElementPresent()) {
            System.out.println("[DEBUG] Price element not present for item: " + getItemName());
            return -1.0;
        }

        String text = price.getText();
        System.out.println("[DEBUG] Price raw text: " + text);
        return Double.parseDouble(text.replace("$", "").trim());
    }


    public void clickAddToCart() {
        addToCartButton.click();
    }
}
