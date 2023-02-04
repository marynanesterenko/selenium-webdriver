package commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AdvancedMouseInteractions extends CommonMethods{

    @Test
    public void learnAdvancedMouseInteractions() throws InterruptedException {
        WebDriver driver=getDriver();
        Actions actions=new Actions(driver);

        WebElement doubleClickBtn=driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
        WebElement rightClickBtn=driver.findElement(By.xpath("//button[contains(text(),'Right')]"));

        //actions class has a lot of different methods to perform various different advanced mouse interactions and actions
        //In this case we are calling the .doubleClick() method and passing the element we wait to double-click on
        //We are calling the .build() method in order to build the actual sequence
        //And then perform() method which actually performs the actions
        actions.doubleClick(doubleClickBtn).build().perform();
        Thread.sleep(3000);

        actions.contextClick(rightClickBtn).build().perform();
        Thread.sleep(3000);

        //we are performing the same double-click but we are using the .moveToElement() method first
        //move the "mouse" to the element and then perform the double click]'
        actions.moveToElement(doubleClickBtn).doubleClick().build().perform();
        Thread.sleep(3000);
    }

    @Test
    public void learnScroll() throws InterruptedException {
        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);

        driver.navigate().to("https://www.saucedemo.com/inventory.html");
        loginToSauceDemo();
        WebElement footer = driver.findElement(By.className("footer_copy"));
        actions.scrollToElement(footer).build().perform();
        Thread.sleep(3000);

        actions.scrollByAmount(0, 500).build().perform();
    }

    @Test
    public void learnDragAndDrop() throws InterruptedException {
        WebDriver driver=getDriver();
        Actions actions=new Actions(driver);
        driver.navigate().to("https://demoqa.com/droppable");

        WebElement draggable=driver.findElement(By.id("draggable"));
        WebElement droppable=driver.findElement(By.id("droppable"));

        //.dragAndDrop(WebElement, WebElement) method will drag the first element passed to the location of the second parameter passed
        actions.dragAndDrop(draggable, droppable).build().perform();
        Thread.sleep(3000);

        ////input[@type='range']
        driver.navigate().to("https://demoqa.com/slider");
        WebElement slider= driver.findElement(By.xpath("//input[@type='range']"));
        actions.dragAndDropBy(slider, 75,0).build().perform();
        Thread.sleep(3000);

        driver.navigate().to("http://the-internet.herokuapp.com/hovers");
        WebElement hoverIcon=driver.findElement(By.xpath("//div[@class='figure'][1]"));
        //we are using the .moveToElement method to essentially hover over a specific element
        actions.moveToElement(hoverIcon).build().perform();
        WebElement viewProfileLink =driver.findElement(By.xpath("//div[@class='figure'][1]//a"));
        actions.keyDown(Keys.CONTROL).click(viewProfileLink).keyUp(Keys.CONTROL).build().perform();

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
