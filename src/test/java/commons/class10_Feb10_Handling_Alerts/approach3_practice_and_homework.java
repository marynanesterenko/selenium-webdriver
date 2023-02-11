package commons.class10_Feb10_Handling_Alerts;

import commons.class05_Feb01_CSS_Locators.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class approach3_practice_and_homework extends CommonMethods {

    @Test
    public void findAlert() throws InterruptedException{
        WebDriver driver = getDriver();
        WebDriverWait drWait = new WebDriverWait(driver, Duration.ofSeconds(60));
        JavascriptExecutor js = (JavascriptExecutor)driver;

        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frm1']"));
        driver.switchTo().frame(frame1);

        WebElement drop = driver.findElement(By.id("selectnav1"));
        Select dropOptions = new Select(drop);

        drWait.until(ExpectedConditions.textToBePresentInElement(drop, "- Alerts"));
        dropOptions.selectByVisibleText("- Alerts");

        driver.switchTo().defaultContent();
        driver.switchTo().frame(frame1);
        WebElement alertBox = driver.findElement(By.xpath("//button[@id='alertBox']"));
        js.executeScript("arguments[0].scrollIntoView(true)", alertBox);
        alertBox.click();

        Alert alert = drWait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);

        Assert.assertTrue("Alert Box did not appear.", alert.getText().equalsIgnoreCase("I am an alert box!"));
        alert.accept();
    }

    @Before
    public void setUp(){
        createDriver("https://www.hyrtutorials.com/p/frames-practice.html");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }
}
