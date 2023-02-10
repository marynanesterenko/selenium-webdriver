package commons.class05_Feb03_Advanced_Mouse_Interactions;

import commons.class04_Feb01_CSS_Locators.CommonMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Double_Click_Action extends CommonMethods {

    @Test
    public void learnAdvancedMouseInteractions() throws InterruptedException {
        WebDriver driver = getDriver();

        // creating an Object of the Actions Class and passing Webdriver's Object as a parameter to Action's Class Constructor
        Actions actions = new Actions(driver);

        // creating an instance of the WebElement Interface to represent the web elements on the web page
        WebElement doubleClickBtn = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
        WebElement rightClickBtn = driver.findElement(By.xpath("//button[contains(text(),'Right')]"));

        // Actions Class has a lot of different methods to perform various advanced mouse interactions and actions
        // in this case we are calling the .doubleClick() method and passing the element we want to double-click on
        // we are calling the .build() method in order to build the actual sequence
        // and then .perform() method which actually performs the action of double-clicking
        actions.doubleClick(doubleClickBtn).build().perform();

        // in this case we are performing the same action as double-click, but we are using the .moveToElement() method
        // to first move the "mouse" to the element and then perform the double click
        actions.moveToElement(doubleClickBtn).doubleClick().perform();
        Thread.sleep(3000);

        // the Actions Class .contextClick() method will perform a right click/context menu click(synonyms)
        // on the web element that is passed as a parameter
        actions.contextClick(rightClickBtn).build().perform();
        Thread.sleep(3000);

        // here we are performing the same double-click action, but we are using the .moveToElement() method first
        // to move the "mouse" to the element and then perform the double click
        actions.moveToElement(doubleClickBtn).doubleClick().build().perform();
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
