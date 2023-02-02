package commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utils.DriverUtils;

public class BrowserNavigation extends CommonMethods {
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

        driver.navigate().back();
        Thread.sleep(3000);

        // this method will refresh the page
        driver.navigate().refresh();
        Thread.sleep(3000);
    }

    @Test
    public void practice1() throws InterruptedException {
        WebDriver driver = getDriver();
        loginToSauceDemo();
        Thread.sleep(3000);
    }


    @After
    public void cleanUp(){
        quitDriver();
    }
}
