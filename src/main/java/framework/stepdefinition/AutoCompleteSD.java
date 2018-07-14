package framework.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.web_pages.HomePage;
import org.testng.Assert;

public class AutoCompleteSD {

    private HomePage homePage = new HomePage();

    String URL = SharedSD.getDriver().getCurrentUrl();

    @Given("^I am on home page$")
    public void iAmOnHomePage(){
        Assert.assertEquals(URL, "https://floating-anchorage-58495.herokuapp.com/");}

    @When("^I search on top search bar with text \'([^\"]*)\'$")
    public void searchText(String anyText) { homePage.getAutoComplete(); }

    @Then("^I verify 'Title: I will teach you IOS' as displayed result$")
    public void verifySearchResult() {
        homePage.verifyTitle();
    }

}

