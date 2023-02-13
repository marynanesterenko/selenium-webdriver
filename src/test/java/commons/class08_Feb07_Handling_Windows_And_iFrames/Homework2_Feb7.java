package commons.class08_Feb07_Handling_Windows_And_iFrames;

import commons.class05_Feb01_CSS_Locators.CommonMethods;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 Homework 2
 In a new homework class open https://www.hyrtutorials.com/p/frames-practice.html
 Scroll down so that the “Frame2:” is visible (this iFrame should be talking about “Basic Controls in HTML”)
 Switch to the frame and fill out the form WITH FAKE INFO
 */

public class Homework2_Feb7 extends CommonMethods {
    @Test
    public void learnWindowHandlingHW() throws InterruptedException{
        WebDriver driver = getDriver();

        // since the task is asking us to scroll down, we should think right away of the Actions Class
        // lets create an Object of this Class, so that we can use it to call one of it's methods later
        Actions actions = new Actions(driver);

        // since we can have Selenium scroll down to a particular web element,
        // we first need to find it
        WebElement iframe2 = driver.findElement(By.id("frm2"));
        actions.scrollToElement(iframe2).build().perform();

        driver.switchTo().frame(iframe2);

        WebElement firstName = driver.findElement(By.xpath("//div[@class='basicControls']//input[@id='firstName']"));
        firstName.sendKeys("Jessica");

        WebElement lastName = driver.findElement(By.xpath("//div[@class='basicControls']//input[@id='lastName']"));
        lastName.sendKeys("Simpson");

        WebElement gender = driver.findElement(By.xpath("//div[@class='basicControls']//input[@id='femalerb']"));
        gender.click();

        WebElement languages = driver.findElement(By.xpath("//div[@class='basicControls']//input[@id='englishchbx']"));
        languages.click();

        WebElement email = driver.findElement(By.xpath("//div[@class='basicControls']//input[@id='email']"));
        email.sendKeys("jessica.simpson@email.com");

        WebElement password = driver.findElement(By.xpath("//div[@class='basicControls']//input[@id='password']"));
        password.sendKeys("password123");

        WebElement registerBtn = driver.findElement(By.xpath("//div[@class='basicControls']//button[@id='registerbtn']"));
        registerBtn.click();

        Thread.sleep(3000);

    }

    @Before
    public void setUp() {
        createDriver("https://www.hyrtutorials.com/p/frames-practice.html");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }
}
