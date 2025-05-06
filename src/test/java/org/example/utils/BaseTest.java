package org.example.utils;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.example.pages.LoginPageBase;
import org.example.pages.MenuPageBase;
import org.example.pages.ProductPageBase;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest extends AbstractTest implements ICustomTypePageFactory {

    public WebDriver getDriver() {
        return super.getDriver();
    }

    protected LoginPageBase getLoginPage() {
        return initPage(getDriver(), LoginPageBase.class);
    }

    protected MenuPageBase getMenuPage() {
        return initPage(getDriver(), MenuPageBase.class);
    }

    protected ProductPageBase getProductPage() {
        return initPage(getDriver(), ProductPageBase.class);
    }
}
