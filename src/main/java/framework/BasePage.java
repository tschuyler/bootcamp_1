package framework;

import framework.stepdefinition.SharedSD;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class BasePage {


    public void clickOn(By locator) {
        try {
            SharedSD.getDriver().findElement(locator).click();
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }
    }

    public void sendText(By locator, String text) {
        try {
            SharedSD.getDriver().findElement(locator).sendKeys(text);
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }
    }

    public String getTextFromElement(By locator) {
        String text = null;
        try {
            text = SharedSD.getDriver().findElement(locator).getText();
        } catch (NoSuchElementException e) {
            Assert.fail("Element is not found with this locator: " + locator.toString());
            e.printStackTrace();
        }

        return text;
    }

    public void clickOnBrowserBackArrow() {
        SharedSD.getDriver().navigate().back();
    }

    public void clickOnBrowserForwardArrow() {
        SharedSD.getDriver().navigate().forward();
    }

    public void refreshBrowser() {
        SharedSD.getDriver().navigate().refresh();
    }

    public void getAutoComplete(By inputField, String enterSomeText, By listOptions, String expectedText) {
        SharedSD.getDriver().findElement(inputField).sendKeys(enterSomeText);
        List<WebElement> list = SharedSD.getDriver().findElements(listOptions);
        for (WebElement ele : list) {
            if (ele.getText().contains(expectedText)) {
                ele.click();
                break;
            }
        }
    }

    public void setValueToInputField(String value, By locator) {
        try {
            SharedSD.getDriver().findElement(locator).sendKeys(value);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("Screenshot taken");
            Assert.fail("Element is not found with this locator " + locator.toString());
        }
    }

    public WebElement findElement(By locator) {
        WebElement element = SharedSD.getDriver().findElement(locator);
        return element;

    }

    public List<WebElement> findElementAsList(By locator) {
        List<WebElement> element = SharedSD.getDriver().findElements(locator);
        return element;
    }
}



