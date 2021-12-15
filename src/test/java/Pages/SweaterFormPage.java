package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SweaterFormPage extends BasePage {

    public SweaterFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement proceedButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    private WebElement proceedCheckoutButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[1]/span")
    private WebElement regularPrice;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div[1]/div[2]/div/span[1]")
    private WebElement discountPrice;

    public String getRegularPrice() {
        return regularPrice.getText().substring(1);
    }

    public String getDiscountPrice(){ return discountPrice.getText().substring(1);}

    public void goToCart() {
        proceedButton.click();
        proceedCheckoutButton.click();
    }


}


