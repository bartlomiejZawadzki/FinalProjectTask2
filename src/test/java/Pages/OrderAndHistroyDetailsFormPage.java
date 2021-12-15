package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderAndHistroyDetailsFormPage extends BasePage{
    public  OrderAndHistroyDetailsFormPage (WebDriver driver){
        super (driver);
    }

    @FindBy(xpath = "//*[@id=\"history-link\"]/span")
    private WebElement orderHistroyButton;

    @FindBy(id = "main")
    protected WebElement search;
    //*[@id="content"]/table

    @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/../tr")
    List<WebElement> orderNumber;

    public void goToOrderHistory(){
        orderHistroyButton.click();
    }

    public String[]  cosCos(String number){
        //WebElement x = driver.findElement(By.xpath("//*[contains(text(), number)]"));
        String text = driver.findElement(By.xpath("//*[@id=\"content-hook_payment_return\"]/div/div/div/p/text()[6]")).getText();

        String[] trimmedText = text.split("refernce");

        for (String str : trimmedText) {
            System.out.println(str);
        }
        return trimmedText;


       // return orderNumber;

        /*
        WebDriverWait wait = new WebDriverWait(driver, 1000);
        wait.until(ExpectedConditions.visibilityOf(search));
        if(search.isEnabled()){
            search.sendKeys(number);
            search.submit();
        }else{
            Assert.fail();

         */

       }

    }



