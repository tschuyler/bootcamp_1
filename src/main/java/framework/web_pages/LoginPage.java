package framework.web_pages;

import framework.BasePage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By emailTextField = By.id("email");
    private By passwordTextField = By.id("password");
    private By submitButton = By.xpath("//button[@class='btn btn-success']");
    private By emailTitle = By.xpath("//label[@for='email']");

    public void enterEmail(String enterEmail)
    {
        sendText(emailTextField, enterEmail);
    }

    public void enterPassword (String enterPassword)
    {
        sendText(passwordTextField, enterPassword);
    }

    public void clickOnSubmitButton () { clickOn(submitButton); }

    public String getEmailTitle() { return getTextFromElement(emailTitle); }

}
