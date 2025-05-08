package org.example.utils;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.example.enums.UserType;
import org.example.pages.*;

public abstract class BaseTest extends AbstractTest implements ICustomTypePageFactory {

    protected LoginPageBase getLoginPage() {
        return initPage(getDriver(), LoginPageBase.class);
    }

    protected MenuPageBase getMenuPage() {
        return initPage(getDriver(), MenuPageBase.class);
    }

    protected ProductPageBase getProductPage() {
        return initPage(getDriver(), ProductPageBase.class);
    }

    public CartPageBase getCartPage() {
        return initPage(getDriver(), CartPageBase.class);
    }

    public CheckoutPageBase getCheckoutPage() {
        return initPage(getDriver(), CheckoutPageBase.class);
    }

    public ProductPageBase loginToAccount() {
        return getLoginPage().login(UserType.STANDARD_USER);
    }
}
