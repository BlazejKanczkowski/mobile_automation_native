package org.example.tests;

import io.appium.java_client.InteractsWithApps;
import org.example.enums.UserType;
import org.example.pages.ProductPageBase;
import org.example.utils.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SessionPersistenceTest extends BaseTest {

    @Test
    public void testSessionPersistenceAfterAppRestart() {

        loginToAccount();

        WebDriver driver = getDriver();
        if (!(driver instanceof InteractsWithApps)) {
            Assert.fail("Driver does not support app interactions.");
        }

        InteractsWithApps appControl = (InteractsWithApps) driver;
        appControl.runAppInBackground(Duration.ofSeconds(5));

        ProductPageBase productPageAfterRestart = initPage(getDriver(), ProductPageBase.class);
        Assert.assertTrue(productPageAfterRestart.isProductListVisible(), "User should remain logged in after app relaunch.");
    }
}
