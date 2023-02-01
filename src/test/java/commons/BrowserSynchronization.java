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

import java.time.Duration;

public class BrowserSynchronization extends DayOne{
    @Before
    public void setUp(){
        createDriver("https://demoqa.com/progress-bar");
    }

    @Test
    public void learnWaits() {
        WebDriver driver = getDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement startElement = driver.findElement(By.xpath("//button[@id='startStopButton']"));

        WebElement progressBar = driver.findElement(By.cssSelector("#progressBar div.progress-bar"));
        startElement.click();

        // using our driverWait variable to call until method to wait for textTioBePresent
        driverWait.until(ExpectedConditions.textToBePresentInElement(progressBar, "100"));
        System.out.println(progressBar.getText());

        Assert.assertTrue("Value does not match expected", progressBar.getText().contains("100") );
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
