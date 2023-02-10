package commons;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverUtils;
import java.time.Duration;

public class class04_BrowserSynchronization_ImplicitAndExplicitWaits extends DriverUtils {

    @Test
    public void performWaits() {
        WebDriver driver = getDriver();

        //here we are creating an Object of WebDriverWait Class and passing the driver (to access current driver session) and
        //the duration of seconds we want to wait for the expected condition to be true
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // here we are creating an instance of the WebElement Interface
        // "startElement" is a button on our WebPage that we are testing
        // this button can be found on the WebPage by using different locators (xpath, id, css):
        // - xpath: //button[@id='startStopButton']
        // - id: startStopButton
        // - css: #startStopButton
        WebElement startElement = driver.findElement(By.xpath("//button[@id='startStopButton']"));

        // here we are doing the same ting, but with the different WebElement
        // "progressBar" web element can also be found on the WebPage by using different locators (xpath, css):
        // - xpath: //div[@role='progressbar']
        // - css: #progressBar div.progress-bar
        WebElement progressBar = driver.findElement(By.cssSelector("#progressBar div.progress-bar"));

        startElement.click();
        String expectedValue = "100%";

        // here we are using our "driverWait" variable to call "until()" method,
        // so that we can wait for textToBePresentInElement() condition to be true
        // !NOTE: if the condition is true before the time is up it will not wait for the full time
        driverWait.until(ExpectedConditions.textToBePresentInElement(progressBar, "100"));
        System.out.println(progressBar.getText());
        Assert.assertTrue("Value does not match expected" + expectedValue, progressBar.getText().contains("100") );
    }

    // the reason we are placing the @Before and @After annotations here is because it is easier to keep them together
    // we need to copy/paste them in each class, and it is also doesn't matter in which order they are placed
    // Selenium scans the code amd looks out for the keyword, so when it finds @Before - it knows this needs to be executed before anything else
    @Before
    public void setUp(){
        createDriver("https://demoqa.com/progress-bar");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
