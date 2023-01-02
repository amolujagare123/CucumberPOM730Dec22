package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.DarkskyHome;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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

        ArrayList<Integer> timeList = darkskyHome.getTimeList();
        // [9, 11, 1, 3, 5, 7, 9, 11, 1, 3, 5] --> 11 (last index i-->10)

        ArrayList<Integer> timeDiffList = new ArrayList<>();

        for (int i=0;i< timeList.size()-1;i++)
        {
            int time1 = timeList.get(i);
            int time2 = timeList.get(i+1);
            int timeDiff = 0;

            if(time2 > time1)
              timeDiff = time2 - time1 ;
            if(time2 < time1)
                timeDiff = (time2 + 12) - time1 ;

            timeDiffList.add(timeDiff);
        }

        System.out.println(timeDiffList);
       /* boolean flag = true;

        for (int i=0;i< timeDiffList.size();i++)
        {
            if (timeDiffList.get(i)!=2)
                flag = false;
        }

        Assert.assertTrue("some time diff. are not 2",flag);*/

        /*ArrayList<Integer> expectedList = new ArrayList<>(){{
            for (int i=0;i<10;i++)
                add(2);
        }};

        System.out.println("expected="+expectedList);
        System.out.println("actual="+timeDiffList);
        Assert.assertEquals("some time diff. are not 2",
                expectedList,timeDiffList);*/

        int size = timeDiffList.size();
        int frequency = Collections.frequency(timeDiffList,2);

        System.out.println("size="+size);
        System.out.println("frequency="+frequency);

        boolean result = (size==frequency);
        Assert.assertTrue("some time diff. are not 2",result);

        /*Assert.assertEquals("some time diff. are not 2",
                size,frequency);*/


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
