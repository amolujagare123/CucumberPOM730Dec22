package pages;

import org.openqa.selenium.By;

public class DarkskyHome extends Base {

    By searchBox = By.xpath("//form[@id='searchForm']//input[@type='text']");

    public void setSearchBox(String city)
    {
        setValue(searchBox,city);
    }
}
