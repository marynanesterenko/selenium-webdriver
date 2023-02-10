package commons.class04_Feb01_CSS_Locators;

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

/**
 What are some differences between implicit and explicit wait?
 Implicit wait:
 * 1. When we are using Implicit Wait - we are specifying a duration for a single web element to be visible
 * 2. Can be changed anywhere throughout our code using driver.mange.timeouts.implicitlyWait()
 * 3. Implicit wait applies specifically to all WebElements that are using it
 * 4. Different syntax: driver.manage.timeouts.implicitlyWait(int time)

 Explicit wait:
 * 1. when we are using Explicit Wait - we are waiting for a specific condition to be true(meaning something needs to happen on the Web Page) with a specified duration
 * 2. Can only be changed using the WebDriverWait class
 * 3. Explicit wait applies to a particular scenario (could be WebElement could be url, text, etc)
 * 4. Different syntaxL WebDriverWait driverWait = new WebDriverWait(WebDriver driver, Duration ofTime)
 Used like: driverWait.until(ExpectedConditions.condition());

 File upload using Selenium:
 * We first need to find the input element for the file upload, then we need to find the path to the
 * file we want to upload. Then we use the .sendKeys() with the file path in order to upload the file.
 * Example: element.sendKeys(“Users/fakeuser/Pictures/sdet.png”);
 */
public class Browser_Synchronization_Implicit_And_Explicit_Waits extends DriverUtils {

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
