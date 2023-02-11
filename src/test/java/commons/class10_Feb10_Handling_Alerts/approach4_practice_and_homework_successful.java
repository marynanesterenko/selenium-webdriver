package commons.class10_Feb10_Handling_Alerts;

import commons.class05_Feb01_CSS_Locators.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Open https://www.hyrtutorials.com/p/frames-practice.html in a new class
 * Enter frame 1
 * Select - Alerts from the first dropdown in this frame
 * Re-enter the frame (You need to do this since the frame refreshes)
 * Click the alert button and verify the text in the alert
 */
public class approach4_practice_and_homework_successful extends CommonMethods {

    @Test
    public void findAlert(){
        WebDriver driver = getDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // simultaneously finding the iframe and switching to it
        // basically, the element of the iframe will be found first
        // then that iframe's locator will be passed as an argument to the "driver.switchTo().frame()" chain of methods
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frm1']")));

        // here we are finding the locator of the dropdown element within the frame
        WebElement dropdown = driver.findElement(By.id("selectnav1"));

        // here we have created an Object of the Select Class - "dropdownOptions"
        Select dropdownOptions = new Select(dropdown);

        // Explicitly waiting 10 seconds for the web elements to load on the page
        // explicit - what condition we are waiting for to happen, in this case:
        // test "- Alerts" needs to appear on the "dropdown" web element
        driverWait.until(ExpectedConditions.textToBePresentInElement(dropdown, "- Alerts"));

        // this is why we had to create an Object of the Class Select earlier,
        // so that we can use this Object to call the method, which belongs to Select Class - ".selectByVisibleText()"
        dropdownOptions.selectByVisibleText("- Alerts");

        // we need to paste these two lines because the moment we select the "Alerts" from the dropdown,
        // the iframe gets refreshed, and we need to sort of "re-find" the locator of the frame again
        // so that Selenium can proceed to locating the "Click Me" button
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frm1']")));

        // simultaneously finding the "Click Me" button within the borders of an iframe, and clicking on it
        driver.findElement(By.xpath("//button[@id='alertBox']")).click();

        // creating an instance of the Alert Interface, and explicitly waiting until the alert is present on the top of the web page
        Alert alert = driverWait.until(ExpectedConditions.alertIsPresent());

        // grabbing the test from the alert and asserting that it indeed popped up
        Assert.assertTrue("Alert box is not there!", alert.getText().equalsIgnoreCase("I am an alert box!"));

        // clicking OK on the alert
        alert.accept();
    }

    @Before
    public void setUp(){
        createDriver("https://www.hyrtutorials.com/p/frames-practice.html");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
