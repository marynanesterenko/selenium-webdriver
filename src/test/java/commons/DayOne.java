package commons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

// This is the Main paige

public class DayOne {

    // instance variable
    private static WebDriver driver;

    //
    public void createDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/driver/chromedriver.exe");
        driver = new ChromeDriver(); // "driver" is an Object of the Interface "WebDriver"
        driver.get(url); // opens up the URL of the Web App, that we want to test
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void quitDriver(){
        driver.close(); // closes the specific tab
        driver.quit(); // ends the whole driver session
    }

    // getter method for our driver variable, because it is "private"
    public WebDriver getDriver(){
        return driver;
    }
}
