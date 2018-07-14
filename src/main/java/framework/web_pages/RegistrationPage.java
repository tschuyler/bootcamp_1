package framework.web_pages;
import org.openqa.selenium.By;
import framework.BasePage;

import java.util.Random;

public class RegistrationPage extends BasePage {

    private By nameTitle = By.xpath("//label[@for='name']");
    private By nameField = By.name("username");
    private By emailField = By.name("email");
    private By passwordField = By.name("password");
    private By submitButton = By.xpath("//button[@class='btn btn-success']");
    private By signInButton = By.xpath("//a[contains(text(),'Sign In')]");

    public String getNameTitle() { return getTextFromElement(nameTitle); }

    public void enterNameField(String enterName) { sendText(nameField, enterName); }

    public void enterEmailField(String enterEmail) { sendText(emailField, enterEmail); }

    public void enterPassword(String enterPassword) { sendText(passwordField, enterPassword); }

    public void clickOnSubmitButton () { clickOn(submitButton); }

    public void clickOnSignInButton () { clickOnSignInButton();}

    public void enterRandomEmail (String enterRandomEmail) {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        sendText(emailField,("username"+ randomInt +"@gmail.com"));
    }

}
