package com.suitsupply.automation.pageObjects;

import com.suitsupply.automation.helper.BasePage;
import net.serenitybdd.core.exceptions.SerenityManagedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Sripriya Srinivasan on 07/06/2020.
 */
public class CustomSuitePage extends BasePage {



    @FindBy(xpath ="//button[contains(text(),'JACKET')]")
    WebElement jacketChooseMenu;

    @FindBy(xpath ="//button[contains(text(),'FABRIC')]")
    WebElement fabricChooseMenu;

    @FindBy(xpath ="//button[contains(text(),'TROUSERS')]")
    WebElement trousersChooseMenu;

    @FindBy(xpath ="//button[contains(text(),'EXTRA TROUSERS')]")
    WebElement extraTrousersChooseMenu;

    @FindBy(xpath ="//button[contains(text(),'WAISTCOAT')]")
    WebElement waistCoatChooseMenu;

    @FindBy(xpath ="//button[contains(text(),'SIZE')]")
    WebElement sizeChooseMenu;


    @FindBy(xpath = "//cmtm-app")
    WebElement customSuiteIdentifier;

    @FindBy(css=".selector .selector-content")
    WebElement dropdownCustomPage;





    public boolean isPageLoaded(){
        sleepForAwhile(3000);
        waitForElementToBeClickable(customSuiteIdentifier);
        return customSuiteIdentifier.isDisplayed();
    }

    public void clickDropDown(){
        waitForElementToBeClickable(dropdownCustomPage);
        dropdownCustomPage.click();
    }

    /**
     *
     * Below methods are to return if side menu items are displayed or not
     * @return
     */
    public boolean isFabricChooseMenuDisplayed(){
       return fabricChooseMenu.isDisplayed();
    }

    public boolean isJacketChooseMenuDisplayed(){
        return jacketChooseMenu.isDisplayed();
    }

    public boolean isTrousersFitChooseMenuDisplayed(){
        return trousersChooseMenu.isDisplayed();
    }

    public boolean isExtraTrousersChooseMenuDisplayed(){
        return extraTrousersChooseMenu.isDisplayed();
    }

    public boolean isWaistCoatChooseMenuDisplayed(){
        return waistCoatChooseMenu.isDisplayed();
    }

    public boolean isSizeChooseMenuDisplayed(){
        return sizeChooseMenu.isDisplayed();
    }

    public boolean isTrouserSizeSizeChooseMenuDisplayed(){
        throw new IllegalArgumentException("Menu option is still not developed");
    }

    public boolean isTurnUpChooseMenuDisplayed(){
        throw new IllegalArgumentException("Menu option is still not developed");
    }

    public boolean isWaistBandChooseMenuDisplayed(){
        throw new IllegalArgumentException("Menu option is still not developed");
    }

    public boolean isJacketSizeChooseMenuDisplayed(){
        throw new IllegalArgumentException("Menu option is still not developed");
    }



}
