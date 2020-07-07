package com.suitsupply.automation.pageObjects;

import com.suitsupply.automation.helper.BasePage;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Srinivas Budha on 11/3/2018.
 */
public class SelectSuiteOptionsWindow extends BasePage {


    @FindBy(xpath="//button[contains(text(),'Add To Bag')]")
    WebElement addToBagButton;

    @FindBy(xpath="//button[@title='NEXT']")
    WebElement nextButton;

    @FindBy(css=".hydrated .grid")
    WebElement selectionPannel;



    @FindBy (xpath = "//button[@data-id='skip']")
    WebElement skipExtraTrousers;

    @FindBy (xpath = "//button[@data-id='add']")
    WebElement addExtraTrousers;

    @FindBy (xpath = "//span[@class='filter__search-field-title js-menu-fade' and contains(text(),'Color')]")
    WebElement colorFilterOnFabric;

    @FindBy (xpath = "//span[@class='filter__search-field-title js-menu-fade' and contains(text(),'Design')]")
    WebElement designFilterOnFabric;

    @FindBy(xpath="//button[contains(text(),'44')]")
    WebElement sizeCheckBox;

    @FindBy (xpath = "//span[@class='filter__search-field-title js-menu-fade' and contains(text(),'Code')]")
    WebElement codeFilterOnFabric;

    @FindBy(xpath="//a[contains(text(),'Secure checkout')]")
    WebElement secureCheckOutButton;

    /**
     * Below methods are to interact with side panel and select respective items
     */
    public void chooseFabric(String fabricType) {
        chooseAObjectFromSidemenu(fabricType);
        nextButton.click();
    }

    public void chooseJacketFit(String jacketFitType) {
        chooseJacketObjectFromSidemenu(jacketFitType);
        nextButton.click();
    }

    public void chooseTrousersFit(String trouserFirType) {
        chooseAObjectFromSidemenu(trouserFirType);
        nextButton.click();
    }

    public void chooseTurnUp(String turnUpFitType) {
        chooseAObjectFromSidemenu(turnUpFitType);
    }

    public void chooseWaistBand(String waistBandType) {
        chooseAObjectFromSidemenu(waistBandType);
    }

    public void chooseWaistCoat(String waistCoatType) {
        if(waistCoatType.equalsIgnoreCase("SKIP")){
            waitForElementToBeClickable(skipExtraTrousers);
            skipExtraTrousers.click();
        }else{
            addExtraTrousers.click();
            chooseAObjectFromSidemenu(waistCoatType);
        }
        nextButton.click();
    }

    public void addExtraTrouser(String extraTrouser) {
        if(extraTrouser.equalsIgnoreCase("SKIP")){
            waitForElementToBeClickable(skipExtraTrousers);
            skipExtraTrousers.click();
        }else{
            waitForElementToBeClickable(addExtraTrousers);
            addExtraTrousers.click();
            chooseAObjectFromSidemenu(extraTrouser);
        }
        nextButton.click();
    }

    public void clickNext(){
        nextButton.click();
    }

    public void selectTrouserSize(String trouserSize) {
        selectSize("trousers",trouserSize);
    }

    public void selectJacketSize(String jacketSize) {
        selectSize("jacket",jacketSize);
    }

    public void selectWaistCoatSize(String waistCoatSize) {
        if(!waistCoatSize.equalsIgnoreCase("NO")){
            selectSize("waistcoat",waistCoatSize);
        }


    }

    /**
     * This method is to check if ADD to cart button is displayed or not
     * @return
     */
    public boolean isAddToBagButtonEnabled(){
       boolean flag=false;
        try{
            if(addToBagButton.isEnabled()){
                flag=true;
            }
            return flag;
        }catch (ElementNotVisibleException e){
            return flag;
        }

    }

    /**
     * This method is to click on AddToBag button
     */
    public void clickAddToBagButton(){
        waitForElementToBeClickable(addToBagButton);
        addToBagButton.click();
    }

    /**
     * This method is to click on Secure Checkout button
     */
    public void clickSecureCheckoutButton(){
        waitForElementToBeClickable(secureCheckOutButton);
        secureCheckOutButton.click();
    }


    /**
     * This method is to click on the objectType in side pannel
     * @param objectType
     */
    private void chooseAObjectFromSidemenu(String objectType) {
        waitForElementToBeClickable(selectionPannel);
        WebElement identifyObject = getDriver().findElement(By.xpath("//div[@class='item-name' and contains(text(),'"+objectType+"')]"));
        waitForElementToBeClickable(identifyObject);
        identifyObject.click();
    }

    private void chooseJacketObjectFromSidemenu(String objectType) {
        waitForElementToBeClickable(selectionPannel);
        WebElement identifyObject = getDriver().findElement(By.xpath("//h2[contains(text(),'"+objectType.split("-")[0].trim().toUpperCase()+"')]"));
        waitForElementToBeClickable(identifyObject);
        identifyObject.click();
        identifyObject.click();

        WebElement exactJacket = getDriver().findElement(By.xpath("//h2[contains(text(),'"+objectType.split("-")[1].trim()+"')]"));
        waitForElementToBeClickable(exactJacket);
        exactJacket.click();
    }

    /**
     * This method is to click on size selection panel
     * @param size
     */
    private void selectSize(String type,String size) {
        waitForElementToBeDisplayed(selectionPannel);
        WebElement sizeCheckBox = getDriver().findElement(By.xpath("//div[@id='"+type+"']//button[contains(text(),'" + size + "')]"));
        Scroll.to(sizeCheckBox);
        waitForElementToBeClickable(sizeCheckBox);
        sizeCheckBox.click();
    }
}
