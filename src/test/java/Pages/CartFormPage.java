package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class CartFormPage extends BasePage {
    public CartFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "checkout-delivery-step")
    private WebElement shippingButton;

    @FindBy(xpath = "//*[@id=\"js-delivery\"]/button")
    private WebElement continueButton;

    @FindBy(id = "payment-option-1")
    private WebElement paymentOptionOne;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement agreeTermsCheckBox;

    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    private WebElement paymentConfirmationButton;

    @FindBy(css = "div.address")
    private WebElement addressSummaryConfirmation;


    public void proceedCart() {
        shippingButton.click();
        continueButton.click();
        paymentOptionOne.click();
        agreeTermsCheckBox.click();
        paymentConfirmationButton.click();
    }

    public String getAddressConfirmationMessage() {
        return addressSummaryConfirmation.getText();
    }
}



