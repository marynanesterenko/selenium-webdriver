package commons.class05_Feb03_Advanced_Mouse_Interactions;

import commons.class04_Feb01_CSS_Locators.CommonMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Scroll_Action extends CommonMethods {
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

    @Before
    public void setUp(){
        createDriver("https://www.saucedemo.com/inventory.html");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
