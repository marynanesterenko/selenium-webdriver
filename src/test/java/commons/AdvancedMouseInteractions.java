package commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AdvancedMouseInteractions extends CommonMethods{

    @Test
    public void learnAdvancedMouseInteractions() throws InterruptedException{
        WebDriver driver = getDriver();

        // creating an Object of the Actions Class and passing driver asw a parameter to it's constructor
        Actions actions = new Actions(driver);

        // created two web elements that represent the actual buttons
        WebElement doubleClickBtn = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
        WebElement rightClickBtn = driver.findElement(By.xpath("//button[contains(text(),'Right')]"));

        //we are performing the same double-click, but we are using the .moveToElement() method first
        //move the "mouse" to the element and then perform the double click'
        actions.doubleClick(doubleClickBtn).build().perform();
        Thread.sleep(3000);

        // the actions .contextClick() method will perform a right click/context click (synonyms) on the web element that is
        actions.contextClick(rightClickBtn).build().perform();
        Thread.sleep(3000);
    }

    @Before
    public void setUp(){
        createDriver("https://www.saucedemo.com/inventory.html");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
