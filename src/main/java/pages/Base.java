package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static stepDefinition.SharedSD.getDriver;

public class Base {

    public static WebElement webAction(By locator) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(50)) // max time
                .pollingEvery(Duration.ofSeconds(5)) // every 5 seconds
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementClickInterceptedException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(ArithmeticException.class)
                .ignoring(Exception.class)
                .withMessage(
                        "WebDriver waited for 50 seconds but still " +
                                "could not find the element therefore " +
                                "Timeout Exception has been thrown");

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver)
            {
                return driver.findElement(locator);
            }
        });

        return element;
    }

    public void setValue(By locator,String value)
    {
        // getDriver().findElement(locator).sendKeys(value);

        webAction(locator).sendKeys(value);
    }

    public void clickOn(By locator)
    {
        webAction(locator).click();
    }

    public String getTextFromElement(By locator)
    {
        return  webAction(locator).getText();
    }

    public void selectFromDropdown(By locator, String dropdownText) {

        WebElement wb = webAction(locator);
        Select select = new Select(wb);
        //select element by visible text
        select.selectByVisibleText(dropdownText);
    }

    public void selectFromDropdown(By locator, int index) {
        WebElement wb = webAction(locator);
        Select select = new Select(wb);
        //select element by index
        select.selectByIndex(index);
    }

    public ArrayList<String> getElementTextList(By locator)
    {
        List<WebElement> elements = getDriver().findElements(locator);

        ArrayList<String> txtList = new ArrayList<>();

        for(int i=0;i<elements.size();i++)
            txtList.add(elements.get(i).getText());

        return txtList;
    }
}
