package Tests;

import Pages.OrderAndHistroyDetailsFormPage;
import Pages.UserLogInFormPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderHistoryTest extends BaseTest {

    @Test
    public void shouldFindOrderInHistory(){
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        String userFirstName = "Bartek";
        String userLastName = "Zawadzki";

        UserLogInFormPage logInFormPage = new UserLogInFormPage(driver);

        //logowanie
        logInFormPage.logIn("jlcfgaivperdnelxup@kvhrr.com", "haslo");

        OrderAndHistroyDetailsFormPage orderHistoryFormPage = new OrderAndHistroyDetailsFormPage(driver);

        orderHistoryFormPage.goToOrderHistory();
        waitASecond();

        //String confirmation = orderHistoryFormPage.cosCos("RQXXREOFV");
        //Assert.assertTrue();

    }
}
