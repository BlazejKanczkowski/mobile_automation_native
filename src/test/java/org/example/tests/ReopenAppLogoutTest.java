package org.example.tests;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import io.appium.java_client.InteractsWithApps;
import org.example.pages.ProductListPageBase;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReopenAppLogoutTest extends BaseTest implements IMobileUtils {

    private static final String APP_ID = "com.swaglabsmobileapp";

    @Test
    public void testAppReopenAfterLogin() {

        ProductListPageBase productPage = loginAsStandardUser(true);

        terminateApp(APP_ID);
        //only activateApp didn't work
        ((InteractsWithApps) getDriver()).activateApp(APP_ID);

        Assert.assertFalse(productPage.isPageOpened(), "User was not logged out after app was reopened.");
    }
}
