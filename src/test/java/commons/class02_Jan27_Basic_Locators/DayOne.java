package commons.class02_Jan27_Basic_Locators;

import commons.class04_Feb01_CSS_Locators.CommonMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DayOne extends CommonMethods {
    private static WebDriver driver;

    public void createDriver(String url){
        System.setProperty("webdriver.chrome.driver", "src/test/java/com/automation/driver/chromedriver");

        driver = new ChromeDriver();

        driver.get(url);

        //Sets up an implicit wait that waits the Duration.ofSeconds() for every element while checking every 500
        //milli seconds before throwing NoSuchElementFoundException
        //Note: if the element exists before the time is up it will not wait for the full time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void quitDriver(){
        driver.close();
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
