package commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class BrowserNavigation extends DayOne {
    //pre-condition
    @Before
    public void setUp(){
        createDriver("http://saucedemo.com/");
    }

    @Test
    public void learnBrowserNavigation() throws InterruptedException{
        WebDriver driver = getDriver();

        driver.navigate().to("http://18.116.88.132:8080/bank/login");
        Thread.sleep(3000);
    }


    @After
    public void cleanUp(){
        quitDriver();
    }
}
