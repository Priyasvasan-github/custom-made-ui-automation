package com.suitsupply.automation.pageActions;

import com.suitsupply.automation.helper.ChooseMenuOptions;
import com.suitsupply.automation.pageObjects.CustomSuitePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

/**
 * Created by Sripriya srinivasan on 07/03/2020.
 */
public class CustomSuiteActions {

    private CustomSuitePage customSuitePage;
    @Step
    public void launch(){
        customSuitePage.open();
    }
    /**
     * This method is to verify if the expected side menu option is displayed or not
     * @param menuOption
     * @return
     */
    @Step
    public boolean isMenuOptionToSelectDisplayed(String menuOption){
        switch (menuOption.toUpperCase()){
            case ChooseMenuOptions.FABRIC : return customSuitePage.isFabricChooseMenuDisplayed();
            case ChooseMenuOptions.JACKET : return customSuitePage.isJacketChooseMenuDisplayed();
            case ChooseMenuOptions.TROUSERS : return customSuitePage.isTrousersFitChooseMenuDisplayed();
            case ChooseMenuOptions.TURN_UP : return customSuitePage.isTurnUpChooseMenuDisplayed();
            case ChooseMenuOptions.WAISTBAND : return customSuitePage.isWaistBandChooseMenuDisplayed();
            case ChooseMenuOptions.WAISTCOAT : return customSuitePage.isWaistCoatChooseMenuDisplayed();
            case ChooseMenuOptions.EXTRA_TROUSERS : return customSuitePage.isExtraTrousersChooseMenuDisplayed();
            case ChooseMenuOptions.TROUSERS_SIZE : return customSuitePage.isTrouserSizeSizeChooseMenuDisplayed();
            case ChooseMenuOptions.JACKET_SIZE : return customSuitePage.isJacketSizeChooseMenuDisplayed();
            case ChooseMenuOptions.SIZE : return  customSuitePage.isSizeChooseMenuDisplayed();
            default: throw new IllegalArgumentException("check the menu Option provided");
        }
    }

    @Step
    public void clickDropDown(){
        customSuitePage.clickDropDown();
    }


    @Step
    public boolean isPageLoaded(){
        return customSuitePage.isPageLoaded();
    }

}
