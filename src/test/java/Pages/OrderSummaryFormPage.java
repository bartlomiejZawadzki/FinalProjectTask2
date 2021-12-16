package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class OrderSummaryFormPage extends BasePage {

    public OrderSummaryFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"order-items\"]/div/div/div[3]/div/div[1]")
    private WebElement priceBoughtProduct;

    @FindBy(xpath = "//*[@id=\"order-items\"]/div/div/div[3]/div/div[3]")
    private WebElement orderPrice;

    @FindBy(xpath = "//*[@id=\"order-details\"]/ul/li[1]")
    private WebElement orderNumber;

    public String getBoughtSize() {
        String text = driver.findElement(By.xpath("//*[@id=\"order-items\"]/div/div/div[2]/span")).getText();

        String[] trimmedText = text.split(": ");
        String boughtSize = trimmedText[1];

        return boughtSize;
    }

    public double getPriceBoughtProduct() {
        String priceOfProducts = priceBoughtProduct
                .getText()
                .substring(1);

        return Double.valueOf(priceOfProducts);
    }

    public double getOrderPrice() {
        String priceOfOrder = orderPrice
                .getText()
                .substring(1);
        return Double.valueOf(priceOfOrder);
    }

    public String getOrderNumber() {
        String text2 = orderNumber.getText();

        String[] trimmedText = text2.split(": ");
        String orderText = trimmedText[1];

        return orderText;
    }

    public String checkChosenSize(int size) {
        switch (size) {
            case 0:
                return "S";
            case 1:
                return "M";
            case 2:
                return "L";
            case 3:
                return "XL";

            default:
                return "Brak rozmiaru";
        }
    }

    public void takeScreenshot() {
        Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
        try {
            ImageIO.write(fpScreenshot.getImage(), "PNG", new File("C://tmp//FullPageScreenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
