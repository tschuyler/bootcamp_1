package framework.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.web_pages.HomePage;
import framework.web_pages.RegistrationPage;
import org.testng.Assert;

public class RegistrationSD {

    private HomePage homePage = new HomePage();
    private RegistrationPage registrationPage = new RegistrationPage();

    String URL = SharedSD.getDriver().getCurrentUrl();

    @Given("^I am on Registration page$")
    public void iAmOnRegPage() {
        homePage.clickOnJoinButton();
        Assert.assertEquals(URL, "https://floating-anchorage-58495.herokuapp.com/");

    }

    @When("^I enter name as \"([^\"]*)\" email as \"([^\"]*)\" password as \"([^\"]*)\"$")
    public void iEnterNameAsEmailAsPasswordAs(String anyText, String textFields, String value) {

        switch (textFields) {
            case "name":
                registrationPage.enterNameField(anyText);
                break;
            case "email address":
                registrationPage.enterRandomEmail(anyText);
                break;
            case "password":
                registrationPage.enterPassword(value);
                break;
        }
    }

    @And("^I click on ('submit') button$")
    public void iClickOnSubmitButton(String button) {
        registrationPage.clickOnSubmitButton();
    }


    @Then("^I am signed-in as a new user$")
    public void iAmSignedInAsANewUser()  {
            homePage.clickOnProfileButton();
        }
    }





