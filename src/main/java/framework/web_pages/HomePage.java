package framework.web_pages;

import framework.BasePage;
import framework.stepdefinition.SharedSD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    private By signInButton = By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[1]/a");
    private By profileButton = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
    private By joinButton = By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/p/a");
    private By threelySearchBar = By.xpath("//input[@id='aa-search-input']");
    private By allGigs = By.xpath("//*[@class='container section']//*[@class='col-md-3']");
    private By pricetag = By.xpath("//h3/.");
    private By postTitle = By.xpath("//h4/.");
    private By images = By.xpath("//h4/.");

    public void clickOnSignInButton() {
        clickOn(signInButton);
    }

    public void clickOnProfileButton() {
        clickOn(profileButton);
    }

    public void clickOnJoinButton() {
        clickOn(joinButton);
    }

    public void getAutoComplete() {
        WebElement element = SharedSD.getDriver().findElement(By.xpath("//input[@id='aa-search-input']"));
        element.click();
        sendText(threelySearchBar, "ios");
    }

    public void verifyTitle() {
        List<WebElement> dropdown = SharedSD.getDriver().findElements(By.xpath("//input[@id='aa-search-input']"));
        for (WebElement ele : dropdown) {
            if (ele.getText().equalsIgnoreCase("Title: I will teach you IOS")) ;
            ele.click();
            break;
        }

    }

    public int numberOfGigs() {
        List list = findElementAsList(allGigs);
        ArrayList arrayList = new ArrayList<>(list);
        int numOfGigs = arrayList.size();
        return numOfGigs;
    }

    public int numberOfPriceTags() {
        List<WebElement> priceTagList = findElementAsList(pricetag);
        ArrayList<WebElement> al = new ArrayList(priceTagList);
        ArrayList<String> newAl = new ArrayList();
        String s = null;
        for (int i = 0; i < al.size(); i++) {
            s = al.get(i).getText();
            if (s.length() >= 2) {
                newAl.add(s);
            }

        }
        return newAl.size();
    }

    public int numberOfTites() {
        List<WebElement> postTitles = findElementAsList(postTitle);
        ArrayList<WebElement> al = new ArrayList(postTitles);
        ArrayList<String> newAl = new ArrayList();
        String s = null;
        for (int i = 0; i < al.size(); i++) {
            s = al.get(i).getText();
            if (s.length() >= 1) {
                newAl.add(s);
            }

        }
        return newAl.size();
    }
    public int numberOfImages(){
        List <WebElement>itemImage= findElementAsList(images);
        ArrayList <WebElement> al= new ArrayList (itemImage);

        for (int i=0; i<al.size(); i++) {
        }
        return al.size();
    }
}
