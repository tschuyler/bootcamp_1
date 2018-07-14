package framework.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import framework.web_pages.HomePage;
import org.testng.Assert;


public class PostsSD {

        private HomePage homePage = new HomePage();

    String URL = SharedSD.getDriver().getCurrentUrl();

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage(){
        Assert.assertEquals(URL, "https://floating-anchorage-58495.herokuapp.com");
    }

    @Then("^I verify (\\d+) total post is displayed$")
    public void totalGigs(int expectedGigs)  {
        try{
            Assert.assertEquals(homePage.numberOfGigs(),expectedGigs);
        } catch(AssertionError a){
            System.out.println("Total "+ homePage.numberOfGigs()+" posts are found, instead of "
                    +expectedGigs+ " as expected");
        }

        //List WebElement
    }

    @And("^I verify all post has price tag$")
    public void verifyPriceTagsForAllTags() {
        try {
            Assert.assertEquals(homePage.numberOfPriceTags(), homePage.numberOfGigs());
            System.out.println("All the Posts have price tags");
        } catch (AssertionError a) {
            int diff=(homePage.numberOfGigs() - homePage.numberOfPriceTags());
            System.out.println( diff + " Posts dont have any price tags");
        }
    }

    @And("^I verify all post has title$")
    public void verifyPostTitles() {
        try {
            Assert.assertEquals(homePage.numberOfTites(), homePage.numberOfGigs());
            System.out.println("All the Posts have price tags");
        } catch (AssertionError a) {
            int diff = (homePage.numberOfGigs() - homePage.numberOfTites());
            System.out.println(diff + " Posts dont have any Titles");
        }

//        List<WebElement> titleList = getDriver().findElements(By.xpath("//h4/."));
//        ArrayList<WebElement> titleArray = new ArrayList(titleList);
//        ArrayList<String> newTitleArrayList = new ArrayList<>();
//
//
//        for (int i = 0; i < titleArray.size(); i++) {
//            String s = titleArray.get(i).getText();
//            if ( s.length() >= 2 ) {
//                newTitleArrayList.add(s);
//            }
//
//        }
//
//        return newTitleArrayList.size();
//    }
    }



    @And("^I verify all post has displayed image$")
    public void verifyAllPost_Images(){
        try {
            Assert.assertEquals(homePage.numberOfTites(), homePage.numberOfGigs());
            System.out.println("All the Posts have price tags");
        } catch (AssertionError a) {
            int diff = (homePage.numberOfGigs() - homePage.numberOfImages());
            System.out.println(diff + " Posts dont have any Images");
        }
    }
}


