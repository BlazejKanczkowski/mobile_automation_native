package org.example.ios.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListItemComponent extends AbstractUIObject {

    @FindBy(xpath = ".//*[@name='test-Item title']")
    private ExtendedWebElement itemName;

    @FindBy(xpath = ".//*[@name='test-Price']")
    private ExtendedWebElement price;

    @FindBy(xpath = ".//*[@name='test-ADD TO CART']")
    private ExtendedWebElement addToCartButton;

    @FindBy(xpath = ".//*[@name='test-REMOVE']")
    private ExtendedWebElement removeFromCartButton;

    @FindBy(xpath = "//XCUIElementTypeOther[contains(@name, 'test-Item')]")
    private List<ProductListItemComponent> productItems;


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
        if (addToCartButton.isElementPresent() && addToCartButton.isVisible()) {
            addToCartButton.click();
        }
    }

    public boolean isAddToCartVisible() {
        return addToCartButton.isElementPresent() && addToCartButton.isVisible();
    }

    public boolean isInCart() {
        return removeFromCartButton.isElementPresent() && removeFromCartButton.isVisible();
    }

    public void clickItemName() {
        itemName.click();
    }
}
