package org.example.android.components;

import com.zebrunner.carina.utils.android.AndroidService;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartItemComponent extends AbstractUIObject{

    @AndroidFindBy(xpath = ".//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView")
    private List<ExtendedWebElement> titleElements;

    public CartItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductTitle() {
        return titleElements.get(0).getText().trim();
    }
}