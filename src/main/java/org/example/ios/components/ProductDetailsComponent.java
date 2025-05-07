package org.example.ios.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.components.ProductDetailsComponentBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsComponent extends ProductDetailsComponentBase {

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-ADD TO CART']")
    private ExtendedWebElement addToCartButton;

    public ProductDetailsComponent(WebDriver driver) {
        super(driver);
    }

    @Override
    public void addProductToCart() {
        addToCartButton.click();
    }
}
