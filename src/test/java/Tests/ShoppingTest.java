package Tests;

import Pages.*;
import org.junit.Assert;
import org.junit.Test;

public class ShoppingTest extends BaseTest {

    @Test
    public void shouldSweaterBuySuccesfully() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        String userFirstName = "Bartek";
        String userLastName = "Zawadzki";

        UserLogInFormPage logInFormPage = new UserLogInFormPage(driver);

        //logowanie
        logInFormPage.logIn("jlcfgaivperdnelxup@kvhrr.com", "haslo");

        // przejdź na stronę główną
        logInFormPage.backMainPage();

        // sprawdź czy zalogował się poprawny user
        Assert.assertEquals(userFirstName + " " + userLastName, logInFormPage.getUserNameConfirmation());

        ShoppingFormPage shoppingFormPage = new ShoppingFormPage(driver);

        //wybierz sweter
        shoppingFormPage.pickHummingSweater();
        Assert.assertEquals("HUMMINGBIRD PRINTED SWEATER", shoppingFormPage.getSweaterName());

        int chosenSize = 1; // wybór rozmiaru 0-S, 1-M, 2-L, 3-XL
        String chosenQuantity = "5"; // ilość wybranego produktu

        //dodaj konkretny sweter do koszyka
        shoppingFormPage.pickSweaterSize(chosenSize);
        shoppingFormPage.selectQuantity(chosenQuantity);

        SweaterFormPage sweaterFormPage = new SweaterFormPage(driver);

        //sprawdz czy zniżka została poprawnie naliczona
        Assert.assertEquals(Double.parseDouble(sweaterFormPage.getRegularPrice()) * 0.8,
                Double.parseDouble(sweaterFormPage.getDiscountPrice()), 0.2);

        shoppingFormPage.addSweaterToCart();

        //przejdź do koszyka
        sweaterFormPage.goToCart();

        CartFormPage cartFormPage = new CartFormPage(driver);

        //sprawdź poprawność adresu
        String confirmationText = cartFormPage.getAddressConfirmationMessage();
        Assert.assertTrue(confirmationText.contains(userFirstName));
        Assert.assertTrue(confirmationText.contains(userLastName));
        Assert.assertTrue(confirmationText.contains("Warszawa"));
        Assert.assertTrue(confirmationText.contains("nowa"));
        Assert.assertTrue(confirmationText.contains("01-001"));
        Assert.assertTrue(confirmationText.contains("United Kingdom"));

        //zamówienie produktu
        cartFormPage.proceedCart();


        OrderSummaryFormPage orderSummaryFormPage = new OrderSummaryFormPage(driver);

        //sprawdź czy kupiony został prawidłowy rozmiar
        Assert.assertEquals(orderSummaryFormPage.checkChosenSize(chosenSize), orderSummaryFormPage.getBoughtSize());


        //sprawdź czy cena zakupionych porduktów jest prawidłowa
        Assert.assertEquals(orderSummaryFormPage.getOrderPrice(),
                Integer.valueOf(chosenQuantity) * orderSummaryFormPage.getPriceBoughtProduct(), 0.2);

        waitASecond();

        //pobierz numer zamównienia
        String lastOrderNumber = orderSummaryFormPage.getOrderNumber();

        //zrób screenshot
        orderSummaryFormPage.takeScreenshot();

        //przejdź do historii zamówień
        OrderAndHistroyDetailsFormPage orderHistoryFormPage = new OrderAndHistroyDetailsFormPage(driver);
        orderHistoryFormPage.goToOrderHistory();

        //lista zamówień w zmiennej
        String confirmationOrder = orderHistoryFormPage.checkOrderList();

        // sprawdź czy ostatnie zamówienie znajduje się w historii
        Assert.assertTrue(confirmationOrder.contains(orderHistoryFormPage.checkOrderList()));
    }
}
