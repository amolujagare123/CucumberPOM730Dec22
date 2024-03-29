package pages;

import io.cucumber.java.sl.In;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class DarkskyHome extends Base {

    By searchBox = By.xpath("//form[@id='searchForm']//input[@type='text']");
    public void setSearchBox(String city)
    {
        setValue(searchBox,city);
    }
    By currentTemp= By.xpath("//span[@class='summary swap']");
    
    public int getCurrentTemp()
    {
        String tempRaw = getTextFromElement(currentTemp);// 58˚ Clear.
        String tempStr = tempRaw.split("˚")[0];
        return  Integer.parseInt(tempStr);
    }
    
    By timelineTemp= By.xpath("//span[@class='first']//span");
    public int getTimelineTemp()
    {
        String tempRaw = getTextFromElement(timelineTemp);//  58°
        String tempStr = tempRaw.split("°")[0];
        return  Integer.parseInt(tempStr);
    }


    By currentLowTemp= By.xpath("//span[@class='low-temp-text']");
    By currentHighTemp= By.xpath("//span[@class='high-temp-text']");

    public ArrayList<Integer> getCurrentTempList()
    {
        String currentLowTempRaw = getTextFromElement(currentLowTemp);//  44˚
        String tempStr1 = currentLowTempRaw.split("˚")[0];
        int currentLowTempInt = Integer.parseInt(tempStr1);

        String currentHighTempRaw = getTextFromElement(currentHighTemp);//  44˚
        String tempStr2 = currentHighTempRaw.split("˚")[0];
        int currentHighTempInt = Integer.parseInt(tempStr2);

        ArrayList<Integer> tempList = new ArrayList<>() {{
            add(currentLowTempInt);
            add(currentHighTempInt);
        }};

        return tempList;
    }

    By timeLineMinTemp = By.xpath("//a[@data-day='0']//span[@class='minTemp']");
    By timeLineMaxTemp = By.xpath("//a[@data-day='0']//span[@class='maxTemp']");

    public ArrayList<Integer> getTimelineTempList()
    {
        String timelineLowTempRaw = getTextFromElement(timeLineMinTemp);//  68˚
        String tempStr1 = timelineLowTempRaw.split("˚")[0];
        int timelineLowTempInt = Integer.parseInt(tempStr1);

        String timelineHighTempRaw = getTextFromElement(timeLineMaxTemp);//  68˚
        String tempStr2 = timelineHighTempRaw.split("˚")[0];
        int timelineHighTempInt = Integer.parseInt(tempStr2);

        ArrayList<Integer> tempList = new ArrayList<>() {{
            add(timelineLowTempInt);
            add(timelineHighTempInt);
        }};

        return tempList;
    }

    By timeList = By.xpath("//span[@class='hour']/span");

    public  ArrayList<Integer> getTimeList()
    {
        ArrayList<Integer> timeListInt = new ArrayList<>();

        ArrayList<String> timeListRaw = getElementTextList(timeList);
        System.out.println(timeListRaw);

        for (int i=0;i<timeListRaw.size();i++)
        {
            String timeRawStr = timeListRaw.get(i); // "9pm" / "11am"
            int l = timeRawStr.length();
            String timeStr = timeRawStr.substring(0, l-2); // "9" / "11"
            int timeInt = Integer.parseInt(timeStr);
            timeListInt.add(timeInt);
        }
        System.out.println(timeListInt);
        return timeListInt;
    }

    By darkSkyAPI = By.xpath("//a[normalize-space()='Dark Sky API']");

    public void clickDarkSkyAPI()
    {
        clickOn(darkSkyAPI);
    }
}
