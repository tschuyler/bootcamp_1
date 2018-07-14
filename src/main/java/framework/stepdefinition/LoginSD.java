package framework.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.web_pages.HomePage;
import framework.web_pages.LoginPage;
import org.testng.Assert;

import java.net.URL;

public class LoginSD {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    String URL = SharedSD.getDriver().getCurrentUrl();

    @Given("^I am on Threely Login Page$")
    public void iAmOnThreelyLoginPage() {
        Assert.assertEquals(URL, "https://floating-anchorage-58495.herokuapp.com/login");
    }
//        homePage.clickOnSignInButton();
//        Assert.assertEquals(loginPage.getEmailTitle(),"EMAIL ADDRESS:");}

    @When("^I enter username as (n12345@test.com) and password as (123456)$")
    public void enterDataIntoTextFields(String anyText, String textFields) {

        switch (textFields) {
            case "username":
                loginPage.enterEmail(anyText);
                break;
            case "password":
                loginPage.enterPassword(anyText);
                break;
        }
    }

    @And("^I click on (submit) button$")
    public void clickOnSubmitButton(String button) {

        switch (button) {
            case "login":
                loginPage.clickOnSubmitButton();
                break;
        }
    }

    @Then("^I verify (logout button) is displayed$")
    public void clickOnProfileButton(String button) {

        homePage.clickOnProfileButton();
    }
    }



