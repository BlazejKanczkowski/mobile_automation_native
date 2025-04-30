package org.example.android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductListItemComponent extends AbstractUIObject {

    @FindBy(xpath = ".//android.widget.TextView[@content-desc='test-Item title']")
    private ExtendedWebElement itemName;

    @FindBy(xpath = ".//android.widget.TextView[@content-desc='test-Price']")
    private ExtendedWebElement price;

    @FindBy(xpath = ".//android.view.ViewGroup[@content-desc='test-ADD TO CART']")
    private ExtendedWebElement addToCartButton;

    public ProductListItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public double getItemPrice() {
        return Double.parseDouble(price.getText().replace("$", "").trim());
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }
}
