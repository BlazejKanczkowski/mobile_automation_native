package org.example.tests;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import io.appium.java_client.InteractsWithApps;
import org.example.enums.UserType;
import org.example.pages.LoginPageBase;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ReopenAppLogoutTest extends BaseTest implements IMobileUtils {

    private static final String APP_ID = "com.swaglabsmobileapp";

    @Test
    public void testAppReopenAfterLogin() {

        ProductPageBase productPage = loginToAccount();

        terminateApp(APP_ID);
        //only activateApp didn't work
        ((InteractsWithApps) getDriver()).activateApp(APP_ID);

        Assert.assertFalse(productPage.isPageOpened(), "User was not logged out after app was reopened.");
    }
}
