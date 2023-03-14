package commons.cookies;

import commons.class05_Feb01_CSS_Locators.CommonMethods;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingCookies extends CommonMethods {

    @Test
    public void learnCookieHandling() throws InterruptedException{
        WebDriver driver = getDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
}
