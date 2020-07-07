package com.suitsupply.automation.runner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by Sripriya srinivasan on 07/01/2020.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/customMade/suite/", glue = "com.suitsupply.automation.stepDefinitions",tags = {"@tt"})

public class RunFeaturesTest {

}
