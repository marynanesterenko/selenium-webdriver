package commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Set;

public class HandlingWindows extends CommonMethods{
    @Test
    public void learnWindowHandling() throws InterruptedException{
        WebDriver driver = getDriver();
        WebElement tabButton = driver.findElement(By.id("tabButton"));
        WebElement windowButton = driver.findElement(By.id("windowButton"));

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
        WebElement shopYogaBtn = driver.findElement(By.id("//span[contains(text(),'Shop New Yoga')]"));

        actions.keyDown(Keys.CONTROL).click(shopYogaBtn).keyUp(Keys.CONTROL).build().perform();

        ArrayList <String> windowList = new ArrayList<>(driver.getWindowHandles());

        for (String windowHandle : windowList){
            if (!windowHandle.equals(primaryWindow)){
                driver.switchTo().window(windowHandle);

                if(driver.getCurrentUrl().contains("/collections/yoga-new.html")){
                    driver.close();
                }
            }
        }

        Thread.sleep(3000);
    }

    @Before
    public void setUp(){
        createDriver("https://demoqa.com/browser-windows");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
