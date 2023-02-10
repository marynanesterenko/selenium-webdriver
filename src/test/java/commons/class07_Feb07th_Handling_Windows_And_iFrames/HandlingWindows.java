package commons.class07_Feb07th_Handling_Windows_And_iFrames;

import commons.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Set;

public class HandlingWindows extends CommonMethods {
    @Test
    public void learnWindowHandling() throws InterruptedException{
        WebDriver driver = getDriver();

        driver.navigate().to("https://demoqa.com/browser-windows");
        WebElement tabButton = driver.findElement(By.id("tabButton"));
        WebElement windowButton = driver.findElement(By.id("windowButton"));

        //.getWindowHandle() returns the String window handle of the current window
        //Here we are saving the window handle of the current window as a String variable so that we can return to it later
        String primaryWindow = driver.getWindowHandle();

        tabButton.click();
        windowButton.click();

        Thread.sleep(3000);

        Set<String> windowSet = driver.getWindowHandles();
        ArrayList <String> windowList = new ArrayList<>(windowSet);

        //We are creating a for loop to cycle through elements of the windows list then we are making sure that
        //the current window isn't the primary window we were originally in
        for (String window : windowList) {
            if(!window.equals(primaryWindow)){
                driver.switchTo().window(window);
                WebElement header = driver.findElement(By.tagName("h1"));
                System.out.println(header.getText());
                driver.close();
            }
        }

        driver.switchTo().window(primaryWindow);
        Thread.sleep(3000);
    }

    @Test
    public void windowHandlingExample() throws InterruptedException{

        WebDriver driver = getDriver();
        driver.navigate().to("https://magento.softwaretestingboard.com/");

        Actions actions = new Actions(driver);

        String primaryWindow = driver.getWindowHandle();
        WebElement shopNewYogaBtn = driver.findElement(By.xpath("//span[contains(text(),'Shop New Yoga')]"));

        actions.keyDown(Keys.CONTROL).click(shopNewYogaBtn).keyUp(Keys.CONTROL).build().perform();

        ArrayList <String> windowList = new ArrayList<>(driver.getWindowHandles());

        for (String windowHandle : windowList){
            if (!windowHandle.equals(primaryWindow)){
                driver.switchTo().window(windowHandle);

                if(driver.getCurrentUrl().contains("/collections/yoga-new.html")){
                    driver.close();
                }
            }
        }

        WebElement category = driver.findElement(By.xpath("//li[@class='item category8']/strong"));
        Assert.assertTrue("Category does not match expected", category.getText().equalsIgnoreCase("new luma yoga collection"));

        Thread.sleep(3000);

        driver.close();
        driver.switchTo().window(primaryWindow);

        shopNewYogaBtn = driver.findElement(By.xpath("//span[contains(text(),'Shop New Yoga')]"));
        Assert.assertTrue("Shop new yoga button not visible", shopNewYogaBtn.isDisplayed());
    }

    @Before
    public void setUp(){
        createDriver("https://magento.softwaretestingboard.com/");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
