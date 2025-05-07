package org.example.ios;

import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.example.pages.CheckoutPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase implements IMobileUtils {

    @FindBy(xpath = "//XCUIElementTypeTextField[@name='test-First Name']")
    private ExtendedWebElement firstNameField;

    @FindBy(xpath = "//XCUIElementTypeTextField[@name='test-Last Name']")
    private ExtendedWebElement lastNameField;

    @FindBy(xpath = "//XCUIElementTypeTextField[@name='test-Zip/Postal Code']")
    private ExtendedWebElement postalCodeField;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-CONTINUE']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//XCUIElementTypeOther[@name='test-FINISH']")
    private ExtendedWebElement finishButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='THANK YOU FOR YOU ORDER']")
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

    @Override
    public void scrollToFinishButton() {
        swipe(finishButton);
    }

    public ExtendedWebElement getFinishButton() {
        return finishButton;
    }
}
