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
public class approach4_practice_and_homework extends CommonMethods {

    @Test
    public void findAlert(){
        WebDriver driver = getDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frm1']")));
        WebElement dropdown = driver.findElement(By.id("selectnav1"));

        Select dropdownOptions = new Select(dropdown);
        driverWait.until(ExpectedConditions.textToBePresentInElement(dropdown, "- Alerts"));
        dropdownOptions.selectByVisibleText("- Alerts");

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frm1']")));

        driver.findElement(By.xpath("//button[@id='alertBox']")).click();

        Alert alert = driverWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue("Alert box is not there!", alert.getText().equalsIgnoreCase("I am an alert box!"));
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
