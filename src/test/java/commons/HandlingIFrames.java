package commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandlingIFrames extends CommonMethods{

    @Test
    public void learnIframeHandling () throws InterruptedException {
        WebDriver driver = getDriver();

        WebElement iframe1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
        driver.switchTo().frame(iframe1);

        System.out.println(driver.findElement(By.tagName("h1")).getText());

        driver.switchTo().parentFrame();

        Thread.sleep(1000);
    }

    @Test
    public void learnNestedIFrames() throws InterruptedException{
        WebDriver driver = getDriver();
        driver.navigate().to("https://demoqa.com/nestedframes");

        WebElement frame1 = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frame1);
        System.out.println(driver.findElement(By.tagName("body")).getText());
        Thread.sleep(2000);

        driver.switchTo().parentFrame();
        // this is the child
        WebElement frame2 = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        driver.switchTo().frame(frame2);
        System.out.println(driver.findElement(By.tagName("p")).getText());
        Thread.sleep(2000);
    }

    @Before
    public void setUp(){
        createDriver("https://demoqa.com/frames");
    }

    @After
    public void cleanUp(){
        quitDriver();

}

}
