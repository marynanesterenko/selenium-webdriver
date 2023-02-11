package commons.class10_Feb10_Handling_Alerts;

import commons.class05_Feb01_CSS_Locators.CommonMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.*;
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
public class approach1_practice_and_homework extends CommonMethods {

    @Test
    public void findAlert() throws InterruptedException{
        WebDriver dr = getDriver();
        WebDriverWait drWait = new WebDriverWait(dr, Duration.ofSeconds(60));

        WebElement frame1 = dr.findElement(By.xpath("//iframe[@id='frm1']"));
        dr.switchTo().frame(frame1);

        WebElement drop = dr.findElement(By.id("selectnav1"));
        Select dropOptions = new Select(drop);

        drWait.until(ExpectedConditions.textToBePresentInElement(drop, "- Alerts"));
        dropOptions.selectByVisibleText("- Alerts");

        //explicitly changing frames to fix frame-refreshing issue.
        dr.switchTo().defaultContent();
        dr.switchTo().frame(frame1);
        WebElement click = dr.findElement(By.xpath("//button[@id=\"alertBox\"]"));
        click.click();
        Thread.sleep(2000);

        Alert alert1 = drWait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);

        Assert.assertTrue("Alert Box did not appear.", alert1.getText().equalsIgnoreCase("I am an alert box!"));
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
