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
        shoppingFormPage.addSweaterToCart();

        CartFormPage cartFormPage = new CartFormPage(driver);
        //String sweaterRegularPrice= cartFormPage.getRegularPrice();

        // ZROBIC ASERCJE KOSZYKA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
       // Assert.assertEquals(Integer.parseInt(sweaterRegularPrice)*0.8, cartFormPage.getDiscountPrice());

        //przejdź do podsumiwania
        cartFormPage.goToSummary();

        //Assert.assertEquals(chosenSize * Integer.parseInt(chosenQuantity), 5);

        SummaryFormPage summaryFormPage = new SummaryFormPage(driver);

        //sprawdź poprawność adresu
        String confirmationText = summaryFormPage.getAddressConfirmationMessage();
        Assert.assertTrue(confirmationText.contains(userFirstName));
        Assert.assertTrue(confirmationText.contains(userLastName));
        Assert.assertTrue(confirmationText.contains("Warszawa"));
        Assert.assertTrue(confirmationText.contains("nowa"));
        Assert.assertTrue(confirmationText.contains("01-001"));
        Assert.assertTrue(confirmationText.contains("United Kingdom"));

        summaryFormPage.checkSummary();
        OrderAndHistroyDetailsFormPage oder=new OrderAndHistroyDetailsFormPage(driver);
        //oder.cosCos("XRHNHGEBX");

        //zrób screenshot
        ScreenShotFormPage screenShotFormPage = new ScreenShotFormPage(driver);
        screenShotFormPage.takeScreenshot();
    }
}
