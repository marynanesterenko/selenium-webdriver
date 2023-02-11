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

public class approach2_practice_and_homework extends CommonMethods {

    @Test
    public void handleAlert() throws InterruptedException{
        WebDriver driver = getDriver();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@id='frm1']")));

        WebElement iFrame = driver.findElement(By.xpath("//iframe[@id='frm1']"));
        driver.switchTo().frame(iFrame);

        WebElement selectDropdown = driver.findElement(By.id("selectnav1"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", selectDropdown);

        Select select = new Select(selectDropdown);
        select.selectByVisibleText("- Alerts");
        Thread.sleep(3000);

        WebElement alertBtn = driver.findElement(By.xpath("//button[@id='alertBox']"));
        alertBtn.click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        Assert.assertEquals("I am an alert Box!", alert.getText());
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
