package org.example.android.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.components.ProductDetailsComponentBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsComponent extends ProductDetailsComponentBase {

    @AndroidFindBy(accessibility = "test-ADD TO CART")
    private ExtendedWebElement addToCartButton;

    public ProductDetailsComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Override
    public void addProductToCart() {
        addToCartButton.click();
    }
}
