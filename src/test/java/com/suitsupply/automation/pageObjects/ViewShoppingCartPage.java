package com.suitsupply.automation.pageObjects;

import com.suitsupply.automation.helper.BasePage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Sripriya Srinivasan on 07/07/2020.
 */
public class ViewShoppingCartPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Proceed to Purchase')]")
    WebElement proceedToPurchaseButton;

    @FindBy(xpath="//div[@id='fabric']//div[@class='summary-item'][1]/label")
    WebElement jacketFabricText;

    @FindBy(xpath="//div[@id='jacket']//div[@class='summary-item'][1]/span")
    WebElement jacketFitText;

    @FindBy(xpath="//div[@id='size']//div[@class='summary-group'][1]//div[@class='summary-item'][1]/span")
    WebElement jacketSizeText;

    @FindBy(xpath="//div[@id='size']//div[@class='summary-group'][2]//div[@class='summary-item'][1]/span")
    WebElement trousersSizeText;

    @FindBy(xpath="//div[@data-variant-id='DYO-TROUSERS']//p[contains(text(),'Fabric')]/following::p[1]")
    WebElement trousersFabricText;

    @FindBy(xpath="//div[@id='trousers']//div[@class='summary-item'][1]/span")
    WebElement trousersFitText;

    @FindBy(xpath="//div[@data-variant-id='DYO-TROUSERS']//p[contains(text(),'Turn-up')]/following::p[1]")
    WebElement trousersTurnUpText;

    @FindBy(xpath="//div[@data-variant-id='DYO-TROUSERS']//p[contains(text(),'Waistband')]/following::p[1]")
    WebElement trousersWaistBandText;

    @FindBy(xpath="//div[@id='extraTrousers']//div[@class='summary-group'][2]//div[@class='summary-item'][1]/span")
    WebElement extraTrousersText;

    @FindBy(xpath="//div[@id='waistcoat']//div[@class='summary-group'][2]//div[@class='summary-item'][1]/span")
    WebElement waistCoatFabricText;

    @FindBy(xpath="//div[@data-variant-id='DYO-WAISTCOAT']//p[contains(text(),'Fit')]/following::p[1]")
    WebElement waistCoatFitText;

    @FindBy(xpath="//div[@id='size']//div[@class='summary-group'][3]//div[@class='summary-item'][1]/span")
    WebElement waistCoatSizeText;

    @Step
    public boolean isProceedButtonDisplayed(){
        return proceedToPurchaseButton.isDisplayed();
    }

    @Step
    public String getJacketFabricText(){
        return jacketFabricText.getText();
    }

    public String getJacketFitText(){
        return jacketFitText.getText();
    }

    public String getJacketSizeText(){
        return jacketSizeText.getText();
    }

    @Step
    public String getTrouserSizeText(){
        return trousersSizeText.getText();
    }

    @Step
    public String getWaistCoatSizeText(){
        try{
            return waistCoatSizeText.getText();
        }catch(Exception e){
            return "Skipped";
        }
    }

    public String getExtraTrouserText(){
        try{
            return extraTrousersText.getText();
        }catch(Exception e){
            return "Skipped";
        }
    }
    public String getTrouserFabricText(){
        return trousersFabricText.getText();
    }
    public String getTrouserFitText(){
        return trousersFitText.getText();
    }
    public String getTrouserTurnUpText(){
        return trousersTurnUpText.getText();
    }
    public String getTrouserWaistBandText(){
        return trousersWaistBandText.getText();
    }

    @Step
    public String getWaistCoatFabricText(){
        try{
            return waistCoatFabricText.getText();
        }catch(Exception e){
            return "Skipped";
        }
    }
    public String getWaistCoatFitText(){
        try{
            return waistCoatFitText.getText();
        }catch(Exception e){
            return "No";
        }
    }

}
