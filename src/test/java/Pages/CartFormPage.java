package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartFormPage extends BasePage{

    public CartFormPage (WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[1]/span[1]")
    private WebElement regularPrice;

    @FindBy (xpath = "//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span")
    private WebElement discountPrice;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    private WebElement proceedCheckoutButton;

    public void goToSummary(){
        proceedCheckoutButton.click();
    }

    public String getRegularPrice() {
        return regularPrice.getText().substring(1);
    }

    public String getDiscountPrice() {
        return discountPrice.getText();
    }
}


