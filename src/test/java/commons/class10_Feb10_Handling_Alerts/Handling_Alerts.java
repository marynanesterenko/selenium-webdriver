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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Handling_Alerts extends CommonMethods{

    @Test
    public void learnAlertHandling() throws InterruptedException{
        WebDriver driver = getDriver();
        // below line is the explicit wait syntax
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement button1 = driver.findElement(By.id("alertButton"));
        WebElement button2 = driver.findElement(By.id("timerAlertButton"));
        WebElement button3 = driver.findElement(By.id("confirmButton"));
        WebElement button4 = driver.findElement(By.id("promtButton"));

        // Alert Interface has a couple of methods in order to handle Alerts
        // switchTo().alert will switch to the presently active alert
        // we are creating an instance of this Interface by switching
        button1.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println(alert.getText());
        alert.dismiss();

        button2.click();
        // here we are using the explicit wait to wait for the alert to show up before continuing
        driverWait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println(alert.getText());
        // the .dismiss() method is essentially the same as clicking "Cancel" or declining the alert
        alert.dismiss(); // this is where we click "Cancel"
        Thread.sleep(3000);

        // the 2nd and the 3rd lines of this block can be replaced with the following line:
        // Alert alert1 = driverWait.until(ExpectedConditions.alertIsPresent());
        // because the .alertIsPresent() returns the entire driver.switchTo().alert() if the try statement within it passes
        button3.click();
        driverWait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        Thread.sleep(3000);
        System.out.println(alert.getText());
        // the .accept() method is the same as clicking "OK" or confirming the alert
        alert.accept(); // this is where we are clicking "OK" on the alert
        Thread.sleep(3000);
        WebElement okConfirmation = driver.findElement(By.id("confirmResult"));
        Assert.assertTrue("you did not accept the alert", okConfirmation.getText().equalsIgnoreCase("You selected Ok"));
        Thread.sleep(3000);
        // Charlie's implementation of the button3 dismissed alert assertion:
        // ... below lines are after the sout statement in line 55...
        // alert.dismiss();
        // WebElement selectionResult = driver.findElement(By.cssSelector("#confirmResult"));
        // Assert.assertTrue("User did not select Ok/accept the alert", selectionResult.getText().equalsIgnoreCase("You selected ok"));
        // Thread.sleep(1000);

        button4.click();
        // we do not really need the DriverWait here, but it is a good approach to utilize it
        // in case if there is something going on with the website, that is slowing down it's performance
        // it is good to explicitly wait for the condition we are looking for to become true
        driverWait.until(ExpectedConditions.alertIsPresent());
        alert = driver.switchTo().alert();
        Thread.sleep(3000);
        // .sendKeys() method will type in whatever String we pass to it into te input of the alert
        // NOTE: we will not be able to see the test being typed, it sends the message to the Alert itself
        // and not to the input field, and then the moment we accept the alert - it accepts the Task
        alert.sendKeys("Hello World");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        WebElement entryTextConfirmation = driver.findElement(By.id("promptResult"));
        Assert.assertTrue("you did not enter the text and accept the alert", entryTextConfirmation.getText().equalsIgnoreCase("You entered Hello World"));
        Thread.sleep(3000);

        // Jasur's approach for button4 accepted alert assertion:
        // ... below lines are after the Thread.sleep() statement in line 80...
        // alert.accept();
        // WebElement success = driver.findElement(By.xpath("//span[text()='Jasur Kadyrov']"));
        // Assert.assertTrue("Message is not matching", success.isDisplayed());
        // Thread.sleep(3000);

        // Charlies implementation for button4 accepted alert assertion:
        // ... below lines are after the Thread.sleep() statement in line 80...
        // alert.accept();
        // WebElement promptResult = driver.findElement(By.cssSelector("#promptResult"));
        // Assert.assertTrue("User did not type 'Hello World' in the alert", promptResult.getText().equalsIgnoreCase("You entered Hello World"));
        // Thread.sleep(1000);
    }

    @Before
    public void setUp(){
        createDriver("https://demoqa.com/alerts");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }
}

