package com.suitsupply.automation.helper;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Sripriya srinivasan on 07/01/2020.
 */
public class BasePage extends PageObject {

    /*
     * This Method enters data into Text field
     */
    public void enterTextInto(WebElement webElement,String text){
        webElement.click();
        webElement.sendKeys(text);
        waitForElementToBeDisplayed(webElement);
        webElement.sendKeys(Keys.TAB);
    }


    /*
     * This Method makes element to wait till element is Displayed
     * Helps avoiding Stale Element exception
     */
    public void waitForElementToBeDisplayed(WebElement webElement){
        for(int waitCount=1;waitCount<3;waitCount++){
            try{
                waitFor(webElement);
            }catch(Exception e){
                //just created a wait loop where an element will be searched for 30 seconds after page is renderred
            }

        }
    }

    /**
     * This method makes the browser wait till the element becomes clickable
     * @param element
     */
    public void waitForElementToBeClickable(WebElement element){
        try{
            WebDriverWait wait = new WebDriverWait(getDriver(), 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch(Exception e){
            //fail-safeImplementation
        }

    }

    /**
     * This method is to scroll down to a particular element
     * @param element
     */
    public void scrollToView(WebElement element){
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public WebElement getWebElement(String selectorPath) {
        sleepForAwhile(200);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        WebElement element =(WebElement) jsExecutor.executeScript("return " + selectorPath);
        scrollToView(element);
        return element;
    }

    public void sleepForAwhile(long x) {
        try {
            Thread.sleep(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
