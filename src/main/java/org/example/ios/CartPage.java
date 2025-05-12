package org.example.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.example.android.components.CartItemComponent;
import org.example.pages.CartPageBase;
import org.example.pages.CheckoutPageBase;
import org.openqa.selenium.WebDriver;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-CHECKOUT")
    private ExtendedWebElement checkoutButton;

    @ExtendedFindBy(accessibilityId = "test-Item")
    private List<CartItemComponent> items;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<CartItemComponent> getCartItems() {
        return items;
    }

    @Override
    public boolean isCheckoutButtonPresent() {
        return checkoutButton.isElementPresent();
    }

    @Override
    public CheckoutPageBase clickCheckout() {
        swipe(checkoutButton);
        checkoutButton.click();
        return initPage(getDriver(), CheckoutPageBase.class);
    }

    @Override
    public boolean isPageOpen() {
        return checkoutButton.isElementPresent();
    }

    @Override
    public void scrollToCheckoutButton() {
        swipe(checkoutButton);
    }

    @Override
    public boolean checkIfVisibleInCart(String product) {
        for (CartItemComponent item : items) {
            if (item.getProductTitle().equalsIgnoreCase(product)) {
                return true;
            }
        }

        return false;
    }
}
