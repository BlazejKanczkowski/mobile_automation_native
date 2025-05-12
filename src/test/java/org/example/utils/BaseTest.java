package org.example.utils;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.example.enums.UserType;
import org.example.pages.*;
import org.testng.Assert;

public abstract class BaseTest extends AbstractTest implements ICustomTypePageFactory {

    protected LoginPageBase getLoginPage() {
        return initPage(getDriver(), LoginPageBase.class);
    }

    protected SideBarMenuPageBase getMenuPage() {
        return initPage(getDriver(), SideBarMenuPageBase.class);
    }

    protected ProductListPageBase getProductPage() {
        return initPage(getDriver(), ProductListPageBase.class);
    }

    public CartPageBase getCartPage() {
        return initPage(getDriver(), CartPageBase.class);
    }

    public CheckoutPageBase getCheckoutPage() {
        return initPage(getDriver(), CheckoutPageBase.class);
    }

    public ProductListPageBase loginAsStandardUser(boolean useAutoFilling) {
        LoginPageBase loginPageBase = initPage(LoginPageBase.class);
        ProductListPageBase productsPageBase = loginPageBase.login(UserType.STANDARD_USER, useAutoFilling);
        Assert.assertTrue(productsPageBase.isPageOpened(), "Product page is not opened");
        return productsPageBase;
    }
}
