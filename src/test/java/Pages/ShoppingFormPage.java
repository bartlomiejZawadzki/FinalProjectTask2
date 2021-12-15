package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ShoppingFormPage extends BasePage {
    public ShoppingFormPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//*[@id=\"content\"]/section/div/article[2]/div/div[1]/h3/a")
    private WebElement hummingSweaterButton;

    //@FindBy(id="group_1")
    //private WebElement availableSweaterSize;

    @FindBy(xpath = "//*[@id=\"group_1\"]/option[1]/../option")
    List<WebElement> availableSweaterSize;

    @FindBy(xpath = "//*[@id=\"group_1\"]/option[2]")
    private WebElement sizeMedium;

    @FindBy(id="quantity_wanted")
    private WebElement quantityWanted;

    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
    private WebElement addCartButton;

    @FindBy(xpath = "//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement proceedButton;

  //  @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
   // private WebElement proceedCheckoutButton;

    @FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/h1")
    private WebElement sweaterName;

    @FindBy (css = "div.modal-content")
    private WebElement cartConfrimation;


    public void pickHummingSweater (){
        hummingSweaterButton.click();}

    //int size 0-S, 1-M, 2-L, 3-XL
    public void pickSweaterSize(int size) {

        availableSweaterSize
                .get(size)
                .click();
    }

    public void selectQuantity(String quantity){
        waitASecond();
        quantityWanted.click();
        quantityWanted.clear();
        quantityWanted.sendKeys(quantity);
    }

    public void addSweaterToCart(){
        addCartButton.click();
        proceedButton.click();
    //    proceedCheckoutButton.click();
    }

    public String getSweaterName() {
        return sweaterName.getText();
    }

    public String getCartConfirmation(){ return cartConfrimation.getText();}

}
