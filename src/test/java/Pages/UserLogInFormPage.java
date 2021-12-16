package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLogInFormPage extends BasePage {
    public UserLogInFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "/html/body/main/header/nav/div/div/div[1]/div[2]/div[2]/div/a/span")
    private WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[1]/div[1]/input")
    private WebElement userMailInput;

    @FindBy(xpath = "//*[@id=\"login-form\"]/section/div[2]/div[1]/div/input")
    private WebElement userPasswordInput;

    @FindBy(id = "submit-login")
    private WebElement signinButton;

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a[2]/span")
    private WebElement userNameConfirmation;

    @FindBy(xpath = "//*[@id=\"_desktop_logo\"]/a/img")
    private WebElement mainPage;

    public void logIn(String mail, String password) {
        signInButton.click();

        userMailInput.click();
        userMailInput.clear();
        userMailInput.sendKeys(mail);

        userPasswordInput.click();
        userPasswordInput.clear();
        userPasswordInput.sendKeys(password);

        signinButton.click();
    }

    public void backMainPage() {
        mainPage.click();
    }

    public String getUserNameConfirmation() {
        return userNameConfirmation.getText();
    }
}
