package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;

import static stepDefinition.SharedSD.getDriver;

public class HotelsSearchResult extends Base{

    public void clickStarRating(String star)
    {
        By rating = By.xpath("//div[@data-filters-group='class']//input[@name='class="+star+"']");

        //clickOn(rating);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click()",webAction(rating));

        getDriver().navigate().refresh();
    }

    By totalRatings = By.xpath("//div[@data-testid='rating-stars']");
    By totalStars = By.xpath("//div[@data-testid='rating-stars']/span");

    public int getTotalRatings()
    {
        return getDriver().findElements(totalRatings).size();
    }

    public int getTotalStars()
    {
        return getDriver().findElements(totalStars).size();
    }

    By hotelListElements = By.xpath("//div[@data-testid='title']");

    public ArrayList<String> getHotelNameList()
    {
        return  getElementTextList(hotelListElements);
    }

    By priceListRaw = By.xpath("//span[@data-testid='price-and-discounted-price']");

    public ArrayList<Integer> getHotelPriceList()
    {
        ArrayList<Integer> priceListInt = new ArrayList<>();
        ArrayList<String> priceListStrRaw = getElementTextList(priceListRaw); // ₹ 3,022

        for (String priceStrRaw:priceListStrRaw) {

            String priceWithComma = priceStrRaw.split(" ")[1];
           // System.out.println(priceWithComma);

            //String priceStr = priceWithComma.split(",")[0]+priceWithComma.split(",")[1];


            String priceStr= priceWithComma.replace(",", "");

            System.out.println(priceStr);

            priceListInt.add(Integer.parseInt(priceStr));

        }

        return priceListInt ;
    }
}
