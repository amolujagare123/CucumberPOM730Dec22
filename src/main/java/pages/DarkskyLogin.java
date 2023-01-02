package pages;

import org.openqa.selenium.By;

public class DarkskyLogin extends DarkskyAPI{

    By loginBtn= By.xpath("//button[normalize-space()='Log in']");
    public void clickLoginBtn()
    {
        clickOn(loginBtn);
    }
}
