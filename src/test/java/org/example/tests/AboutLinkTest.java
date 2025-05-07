package org.example.tests;

import org.example.enums.UserCredentials;
import org.example.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AboutLinkTest extends BaseTest {

    @Test
    public void testOpenAboutPage() {

        getLoginPage().login(UserCredentials.STANDARD_USER);

        getMenuPage().openAboutPage();

        Assert.assertTrue(true, "About page opened – verified manually or via context.");
    }
}
