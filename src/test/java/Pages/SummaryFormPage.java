package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class SummaryFormPage extends BasePage {
    public SummaryFormPage(WebDriver driver) {
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

    @FindBy(xpath = "//*[@id=\"content-hook_payment_return\"]/div/div/div/p/strong[3]")
    private WebElement orderConfirmation;

    @FindBy(css = "div.address")
    private WebElement addressSummaryConfirmation;

    public void checkSummary() {
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



