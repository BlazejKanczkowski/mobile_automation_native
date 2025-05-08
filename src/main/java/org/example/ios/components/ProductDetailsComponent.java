//package org.example.ios.components;
//
//import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
//import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import io.appium.java_client.pagefactory.iOSXCUITFindBy;
//import org.example.components.ProductDetailsComponentBase;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
//
//public class ProductDetailsComponent extends ProductDetailsComponentBase {
//
//    @iOSXCUITFindBy(accessibility = "test-ADD TO CART")
//    private ExtendedWebElement addToCartButton;
//
//    public ProductDetailsComponent(WebDriver driver) {
//        super(driver);
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//    }
//}
