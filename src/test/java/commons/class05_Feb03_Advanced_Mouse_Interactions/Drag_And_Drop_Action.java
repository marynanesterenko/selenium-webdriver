package commons.class05_Feb03_Advanced_Mouse_Interactions;

import commons.class04_Feb01_Browser_Navigation.CommonMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Drag_And_Drop_Action extends CommonMethods {
    @Test
    public void learnDragAndDrop() throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        driver.navigate().to("https://demoqa.com/droppable");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        //dragAndDrop(WebElement, WebElement) method will drag the first parameter passed to the location of second
        //parameter passed
        actions.dragAndDrop(draggable, droppable).build().perform();

        Thread.sleep(3000);

        driver.navigate().to("https://demoqa.com/slider");

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

        //dragAndDropBy(WebElement, xOffset, yOffset) method will drag the element by the given x and y offset
        actions.dragAndDropBy(slider, -50, 0).build().perform();
        Thread.sleep(1000);
        actions.dragAndDropBy(slider, 70, 0).build().perform();

        Thread.sleep(5000);
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
