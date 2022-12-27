package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.DarkskyHome;

import java.util.ArrayList;

import static stepDefinition.SharedSD.getDriver;


public class DarkskySD {

    DarkskyHome darkskyHome = new DarkskyHome();

    @Given("I am on Darksky Home Page")
    public void i_am_on_darksky_home_page() {

        Assert.assertEquals("This is not Darksky Home page",
                getDriver().getTitle(),
                "Dark Sky - Sansad Marg, New Delhi, Delhi");

    }
    @Then("I verify current temp is equal to Temperature from Daily Timeline")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline() {

        int expected = darkskyHome.getCurrentTemp();
        int actual = darkskyHome.getTimelineTemp();

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals("temperatures are not equal",expected,actual);
    }

    @Then("I verify timeline is displayed with two hours incremented")
    public void iVerifyTimelineIsDisplayedWithTwoHoursIncremented() {

    }

    @Then("I verify today's lowest and highest temp is displayed correctly")
    public void iVerifyTodaySLowestAndHighestTempIsDisplayedCorrectly() {

        ArrayList<Integer> expected = darkskyHome.getCurrentTempList();

        // to scroll the page
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,800)");


        ArrayList<Integer> actual = darkskyHome.getTimelineTempList();

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals("temperatures lists are not equal",expected,actual);

    }
}
