package org.example.android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.example.components.ProductListItemComponentBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public class ProductListItemComponent extends ProductListItemComponentBase {

    @ExtendedFindBy(accessibilityId = "test-Item title")
    private ExtendedWebElement itemName;

    @ExtendedFindBy(accessibilityId = "test-Description")
    private ExtendedWebElement description;

    @ExtendedFindBy(accessibilityId = "test-Price")
    private ExtendedWebElement price;

    @ExtendedFindBy(accessibilityId = "test-ADD TO CART")
    private ExtendedWebElement addToCartButton;

    @ExtendedFindBy(accessibilityId = "test-REMOVE")
    private ExtendedWebElement removeButton;

    public ProductListItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getItemDescription() {
        return description.getText();
    }

    public double getItemPrice() {
        if (!price.isElementPresent()) {
            return -1.0;
        }
        return Double.parseDouble(price.getText().replace("$", "").trim());
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public void clickRemoveFromCart() {
        if (removeButton.isElementPresent()) {
            removeButton.click();
        }
    }

    public void clickItemName() {
        itemName.click();
    }
}
