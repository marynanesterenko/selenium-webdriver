package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverUtils {

    private static WebDriver driver;

    public void createDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
        driver = new ChromeDriver(); // "driver" is an Object of the Interface "WebDriver"
        driver.get(url); // opens up the URL of the Web App, that we want to test
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void quitDriver(){
        driver.close(); // closes the specific tab
        driver.quit(); // ends the whole driver session
    }

    // getter method for our driver variable, because it is "private"
    public WebDriver getDriver(){
        return driver;
    }

    public void loginToSauceDemo(){

        WebDriver driver = getDriver();

        //findElement is the method that looks up for the element in the page source by using different locators
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        WebElement loginButton = driver.findElement(By.id("login-button"));
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click(); // at this point we are logged on
    }
}
