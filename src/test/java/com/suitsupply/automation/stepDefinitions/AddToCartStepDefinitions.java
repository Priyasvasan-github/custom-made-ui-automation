package com.suitsupply.automation.stepDefinitions;

import com.suitsupply.automation.pageActions.SelectSuiteOptionsActions;
import com.suitsupply.automation.pageObjects.ViewShoppingCartPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Sripriya srinivasan on 07/01/2020.
 */
public class AddToCartStepDefinitions {

    @Steps
    SelectSuiteOptionsActions selectSuiteOptions;

    private ViewShoppingCartPage viewShoppingCartPage;

    @When("^he chooses (.*),(.*),(.*),(.*),(.*),(.*),(.*),(.*)$")
    public void selectYourChoiceForCustomSuite(String fabric,String jacket,String trouserFit, String waistCoat,String extraTrousers,String trouserSize,String jacketSize,String waistCoatSize) {
        Serenity.setSessionVariable("fabric").to(fabric);
        Serenity.setSessionVariable("jacket").to(jacket);
        Serenity.setSessionVariable("trouserFit").to(trouserFit);
        Serenity.setSessionVariable("waistCoat").to(waistCoat);
        Serenity.setSessionVariable("extraTrousers").to(extraTrousers);
        Serenity.setSessionVariable("trouserSize").to(trouserSize);
        Serenity.setSessionVariable("jacketSize").to(jacketSize);
        Serenity.setSessionVariable("waistCoatSize").to(waistCoatSize);
        selectSuiteOptions.selectAllTheOptionsOfSuite(fabric,jacket,trouserFit,waistCoat,
                extraTrousers,trouserSize,jacketSize,waistCoatSize);

    }

    @When("^proceeds to Add to Cart$")
    public void addToCart() {
        selectSuiteOptions.navigateToViewCart();
        selectSuiteOptions.navigateToSecureCheckOut();
    }

    @Then("^the summary should have all the options as per selection$")
    public void verifyProductsAddedOnCart() {
        assertThat(viewShoppingCartPage.getJacketFabricText()).contains(Serenity.sessionVariableCalled
                ("fabric").toString());
        assertThat(viewShoppingCartPage.getJacketFitText()).isEqualToIgnoringCase(Serenity.sessionVariableCalled
                ("jacket").toString().split("-")[1].trim());
        assertThat(viewShoppingCartPage.getTrouserFitText()).isEqualToIgnoringCase(Serenity.sessionVariableCalled
                ("trouserFit"));
        if(Serenity.sessionVariableCalled("extraTrousers").toString().equalsIgnoreCase("Skip")){
            assertThat(viewShoppingCartPage.getExtraTrouserText()).isEqualToIgnoringCase("Skipped");
        }else{
            assertThat(viewShoppingCartPage.getExtraTrouserText()).isEqualToIgnoringCase(Serenity.sessionVariableCalled("extraTrousers"));
        }

        if(Serenity.sessionVariableCalled("waistCoat").toString().equalsIgnoreCase("Skip")){
            assertThat(viewShoppingCartPage.getWaistCoatFabricText()).isEqualToIgnoringCase("Skipped");
        }else{
            assertThat(viewShoppingCartPage.getWaistCoatFabricText()).isEqualToIgnoringCase(Serenity.sessionVariableCalled("waistCoat"));
        }

        assertThat(viewShoppingCartPage.getJacketSizeText()).isEqualToIgnoringCase(Serenity.sessionVariableCalled
                ("jacketSize"));
        assertThat(viewShoppingCartPage.getTrouserSizeText()).isEqualToIgnoringCase(Serenity.sessionVariableCalled
                ("trouserSize"));

        if(Serenity.sessionVariableCalled("waistCoatSize").toString().equalsIgnoreCase("No")){
            assertThat(viewShoppingCartPage.getWaistCoatSizeText()).isEqualToIgnoringCase("Skipped");
        }else{
            assertThat(viewShoppingCartPage.getWaistCoatSizeText()).isEqualToIgnoringCase(Serenity.sessionVariableCalled("waistCoatSize"));
        }

    }

}
