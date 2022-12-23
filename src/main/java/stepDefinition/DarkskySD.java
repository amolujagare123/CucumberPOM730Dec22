package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static stepDefinition.SharedSD.getDriver;


public class DarkskySD {

    @Given("I am on Darksky Home Page")
    public void i_am_on_darksky_home_page() {

        getDriver().get("");
    }
    @Then("I verify current temp is equal to Temperature from Daily Timeline")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline() {

    }
}
