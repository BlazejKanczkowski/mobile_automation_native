package org.example.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;

import java.util.HashMap;

public class MobileScrollUtil {

    public static void scrollToElementWithDescription(AppiumDriver driver, String description) {
        String uiScrollables = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                + "new UiSelector().description(\"" + description + "\"));";
        driver.findElement(AppiumBy.androidUIAutomator(uiScrollables));
    }

    public static void scrollDown(AppiumDriver driver) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("percent", 1.0);
        params.put("left", 100);
        params.put("top", 100);
        params.put("width", 600);
        params.put("height", 800);
        driver.executeScript("mobile: scrollGesture", params);
    }

    public static void scrollDownMultipleTimes(AppiumDriver driver, int times) {
        for (int i = 0; i < times; i++) {
            scrollDown(driver);
        }
    }
}
