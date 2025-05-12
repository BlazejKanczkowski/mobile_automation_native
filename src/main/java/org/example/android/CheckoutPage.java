package org.example.android;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.locator.ExtendedFindBy;
import org.example.pages.CheckoutPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase implements IMobileUtils {

    @ExtendedFindBy(accessibilityId = "test-First Name")
    private ExtendedWebElement firstNameField;

    @ExtendedFindBy(accessibilityId = "test-Last Name")
    private ExtendedWebElement lastNameField;

    @ExtendedFindBy(accessibilityId = "test-Zip/Postal Code")
    private ExtendedWebElement postalCodeField;

    @ExtendedFindBy(accessibilityId = "test-CONTINUE")
    private ExtendedWebElement continueButton;

    @ExtendedFindBy(accessibilityId = "test-FINISH")
    private ExtendedWebElement finishButton;

    @ExtendedFindBy(accessibilityId = "test-BACK HOME")
    private ExtendedWebElement backHomeButton;

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
        return backHomeButton.isElementPresent();
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
