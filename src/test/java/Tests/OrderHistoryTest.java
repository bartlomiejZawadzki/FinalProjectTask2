package Tests;

import Pages.OrderAndHistroyDetailsFormPage;
import Pages.OrderSummaryFormPage;
import Pages.UserLogInFormPage;
import org.junit.Assert;
import org.junit.Test;


public class OrderHistoryTest extends BaseTest {

    @Test
    public void shouldFindOrderInHistory() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        String userFirstName = "Bartek";
        String userLastName = "Zawadzki";

        UserLogInFormPage logInFormPage = new UserLogInFormPage(driver);

        //logowanie
        logInFormPage.logIn("jlcfgaivperdnelxup@kvhrr.com", "haslo");

        OrderAndHistroyDetailsFormPage orderHistoryFormPage = new OrderAndHistroyDetailsFormPage(driver);
        OrderSummaryFormPage summaryFormPage = new OrderSummaryFormPage(driver);

        orderHistoryFormPage.goToOrderHistory();
        waitASecond();

        String confirmationOrder = orderHistoryFormPage.checkOrderList();
        String lastOrderNumber = summaryFormPage.getOrderNumber();

        //sprawdź czy jest zamówenie
        Assert.assertTrue(confirmationOrder.contains(lastOrderNumber));

        //String confirmation = orderHistoryFormPage.cosCos("RQXXREOFV");
        //Assert.assertTrue();

    }
}
