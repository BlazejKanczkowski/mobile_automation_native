package org.example.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.example.pages.CheckoutPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase implements IMobileUtils {

    @AndroidFindBy(accessibility = "test-First Name")
    private ExtendedWebElement firstNameField;

    @AndroidFindBy(accessibility = "test-Last Name")
    private ExtendedWebElement lastNameField;

    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    private ExtendedWebElement postalCodeField;

    @AndroidFindBy(accessibility = "test-CONTINUE")
    private ExtendedWebElement continueButton;

    @AndroidFindBy(accessibility = "test-FINISH")
    private ExtendedWebElement finishButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"THANK YOU FOR YOU ORDER\")")
    private ExtendedWebElement confirmationMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void fillForm(String firstName, String lastName, String postalCode) {
        firstNameField.type(firstName);
        lastNameField.type(lastName);
        postalCodeField.type(postalCode);
        continueButton.click();
    }

    @Override
    public void finishOrder() {
        finishButton.click();
    }

    @Override
    public boolean isConfirmationDisplayed() {
        return confirmationMessage.isElementPresent();
    }

    @Override
    public boolean isPageOpened() {
        return finishButton.isElementPresent();
    }

    public ExtendedWebElement getFinishButton() {
        return finishButton;
    }

    @Override
    public void scrollToFinishButton() {
        swipe(finishButton);
    }
}
