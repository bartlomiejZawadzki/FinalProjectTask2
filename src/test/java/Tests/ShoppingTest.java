package Tests;

import Pages.*;
import org.junit.Assert;
import org.junit.Test;

public class ShoppingTest extends BaseTest {

    String userFirstName = "Bartek";
    String userLastName = "Zawadzki";
    String mail = "jlcfgaivperdnelxup@kvhrr.com";
    String pass = "haslo";
    int chosenSize = 1; // wybór rozmiaru 0-S, 1-M, 2-L, 3-XL
    String chosenQuantity = "5"; // ilość wybranego produktu


    @Test
    public void shouldSweaterBuySuccesfully() {
        driver.get("https://mystore-testlab.coderslab.pl/index.php");

        //logowanie
        UserLogInFormPage logInFormPage = new UserLogInFormPage(driver);
        logInFormPage.logIn(mail, pass);

        // przejdź na stronę główną
        logInFormPage.backMainPage();

        // sprawdź czy zalogował się poprawny user
        Assert.assertEquals(userFirstName + " " + userLastName, logInFormPage.getUserNameConfirmation());

        //wybierz sweter
        ShoppingFormPage shoppingFormPage = new ShoppingFormPage(driver);
        shoppingFormPage.pickHummingSweater();
        Assert.assertEquals("HUMMINGBIRD PRINTED SWEATER", shoppingFormPage.getSweaterName());

        //dodaj sweter o konkretnym rozmiarze w konkretnej ilości
        shoppingFormPage.pickSweaterSize(chosenSize);
        shoppingFormPage.selectQuantity(chosenQuantity);

        //sprawdz czy zniżka została poprawnie naliczona
        SweaterFormPage sweaterFormPage = new SweaterFormPage(driver);
        Assert.assertEquals(Double.parseDouble(sweaterFormPage.getRegularPrice()) * 0.8,
                Double.parseDouble(sweaterFormPage.getDiscountPrice()), 0.2);

        shoppingFormPage.addSweaterToCart();

        //przejdź do koszyka
        sweaterFormPage.goToCart();

        //sprawdź poprawność adresu
        CartFormPage cartFormPage = new CartFormPage(driver);
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
