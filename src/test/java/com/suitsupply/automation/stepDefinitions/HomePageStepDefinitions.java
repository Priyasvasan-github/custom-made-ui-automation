package com.suitsupply.automation.stepDefinitions;


import com.suitsupply.automation.pageActions.CustomSuiteActions;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Sripriya srinivasan on 07/01/2020.
 */
public class HomePageStepDefinitions {


    @Steps
    CustomSuiteActions customSuiteActions;


    @Given("^user is accessing suitsupply home page with data (.*),(.*),(.*),(.*)$")
    public void createURL(String mode,String client,String product,String countryCode) {
        customSuiteActions.launch();
        String baseURL=getDriver().getCurrentUrl();
        String newURL=baseURL+"/?mode="+mode+"&client="+client+"&product="+product+"&countryCode="+countryCode;
        getDriver().navigate().to(newURL);
        assertThat(customSuiteActions.isPageLoaded()).isTrue();
    }

    @When("^he check for options in dropdown$")
    public void navigateToMenu() {
        customSuiteActions.clickDropDown();
    }

    @Then("^he should view below options to select$")
    public void verifySideMenuOptionsAreDisplayedCorrectly(DataTable dataTable) {

        List<Map<String, String>> chooseMenuOptions = dataTable.asMaps(String.class, String.class);
        for(int i=1;i<=chooseMenuOptions.get(chooseMenuOptions.size()-1).size();i++){
            assertThat(customSuiteActions.isMenuOptionToSelectDisplayed(chooseMenuOptions.get(0).get("Option"+i))).isTrue();
        }

    }

}
