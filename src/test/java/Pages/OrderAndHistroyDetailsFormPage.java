package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderAndHistroyDetailsFormPage extends BasePage {
    public OrderAndHistroyDetailsFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"history-link\"]/span")
    private WebElement orderHistroyButton;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span")
    private WebElement accountButton;

    @FindBy(id = "main")
    protected WebElement search;


   // @FindBy(xpath = "//*[@id=\"content\"]/table/tbody/../tr")
   // List<WebElement> orderListaaa;

    @FindBy(xpath = "//*[@id=\"content\"]/table")
    WebElement orderList;

    public void goToOrderHistory() {
        accountButton.click();
        orderHistroyButton.click();
    }

    public String checkOrderList() {
        return orderList.getText();
    }

    //  public String getOrderLast() {
    //      return orderListaaa
    //              .get(0)
    //              .findElement(By.xpath("//*[@id=\"content\"]/table/tbody/tr[1]"))
    //              .getText();
    //  }
}





