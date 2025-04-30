package org.example.utils;

import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest extends AbstractTest implements ICustomTypePageFactory {

    public WebDriver getDriver() {
        return super.getDriver();
    }
}
