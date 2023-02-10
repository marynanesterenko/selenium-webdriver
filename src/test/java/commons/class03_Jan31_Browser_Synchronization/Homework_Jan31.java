package commons.class03_Jan31_Browser_Synchronization;

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

/*
    1. Open https://www.timeanddate.com/timer/
    2. Find locators for the start and reset button
    3. Press start button and explicitly wait until time hits 00:01:45 then press the pause button
    4. Assert that the time is indeed 00:01:45 then click reset button and assert that time was reset
 */
public class Homework_Jan31 extends DriverUtils {

    @Test
    public void verifyTimer() {
        WebDriver driver = getDriver();

        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement startButton = driver.findElement(By.xpath("//button[@title='Start timer']"));
        WebElement timer = driver.findElement(By.xpath("//div[@class='timeCount']/span"));
        WebElement resetButton = driver.findElement(By.xpath("//button[@title='Reset and start over']"));

        startButton.click();
        driverWait.until(ExpectedConditions.textToBePresentInElement(timer, "00:01:45"));
        WebElement pauseButton = driver.findElement(By.xpath("//div[@class='timeCount']//button[@title='Stop/pause timer']"));
        pauseButton.click();
        Assert.assertTrue("Time shown doesn't meet the expected result", timer.getText().contains("00:01:45"));

        resetButton.click();
        Assert.assertTrue("Time shown doesn't meet the expected result", timer.getText().contains("00:02:00"));
    }

    @Before
    public void setUp(){
        createDriver("https://www.timeanddate.com/timer/");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
