package org.example.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public abstract class ProductDetailsComponentBase extends AbstractUIObject {

    public ProductDetailsComponentBase(WebDriver driver) {
        super(driver);
    }

    public abstract void addProductToCart();
}
