package commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LearnJavascriptExecution extends CommonMethods{

    @Test
    public void learnJsExecutor () throws InterruptedException {
        WebDriver driver = getDriver();

        // we are casting the driver
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        WebElement hotSellersTitle = driver.findElement(By.xpath("//h2[@class='title']"));

        Thread.sleep(3000);

        // jsExecutor.executeScript("window.scrollBy(0,500)");

        Thread.sleep(3000);

        int yPositionOfHotSellers = hotSellersTitle.getLocation().getY();

        jsExecutor.executeScript("window.scrollBy(0," + yPositionOfHotSellers + ")");

        Thread.sleep(3000);

        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", hotSellersTitle);

        Thread.sleep(3000);

    }



    @Before
    public void setUp(){
        createDriver(" https://magento.softwaretestingboard.com/");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
