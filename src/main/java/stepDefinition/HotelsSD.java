package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import pages.HotelsSearchResult;

import java.util.ArrayList;

public class HotelsSD {

    HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();
/*    @Given("I am on default locations search result screen")
    public void iAmOnDefaultLocationsSearchResultScreen() {


    }*/

    @When("^I select option for stars as (.+)$")
    public void iSelectOptionForStarsAsStars(String starRating) // "5 stars"
    {

        hotelsSearchResult.clickStarRating(starRating.split(" ")[0]);

    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void iVerifySystemDisplaysOnlyStarsHotelsOnSearchResult(String starRating) {

        int expected = Integer.parseInt(starRating.split(" ")[0]);

        int actual = hotelsSearchResult.getTotalStars() / hotelsSearchResult.getTotalRatings();
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals("all ratings ara not :"+expected,
                expected,actual);
    }

    @Given("I am on default locations search result screen")
    public void i_am_on_default_locations_search_result_screen() {

    }


    @Then("I verify {string} is within search result")
    public void iVerifyIsWithinSearchResult(String hotelName) {

        ArrayList<String> hotelList = hotelsSearchResult.getHotelNameList();
        System.out.println(hotelList);

        boolean flag = false;

        for (String hotel:hotelList) {
            if(hotel.contains(hotelName))
                flag = true;
        }

        Assert.assertTrue("The given hotel '"+hotelName+"' not found",flag);
    }

    @Then("I verify system displays all hotels within {string} amount")
    public void iVerifySystemDisplaysAllHotelsWithinAmount(String expectedAmountStr) {

        ArrayList<Integer> priceList = hotelsSearchResult.getHotelPriceList();
        int expectedAmount = Integer.parseInt(expectedAmountStr);
        boolean flag = true;
        for (int price:priceList)
        {
            if(price<expectedAmount)
            {
                flag = false;
                break;
            }
        }

        Assert.assertTrue("all prices are not less that:"+expectedAmount,flag);
    }
}
