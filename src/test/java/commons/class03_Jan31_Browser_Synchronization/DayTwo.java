package commons.class03_Jan31_Browser_Synchronization;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverUtils;

import java.util.List;

public class DayTwo extends DriverUtils {

    // this is a pre-condition, opens the ChromeBrowser
    @Before
    public void setUp(){
        createDriver("https://www.saucedemo.com/");
    }

    @Test
    public void login() throws InterruptedException{

        WebDriver driver = getDriver();

        //findElement is the method that looks up for the element in the page source by using different locators
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click(); // at this point we are logged on


        Thread.sleep(5000);

        // starting from here we are on the Home Page, where the Products are displayed
        WebElement products = driver.findElement(By.className("title"));
        Assert.assertTrue("This element is not on the products page", products.isDisplayed());

        // with List here we are creating the storage ("inventoryItemDescription" variable) for the list of the products on the website
        List<WebElement> inventoryItemDescription = driver.findElements(By.className("inventory_item_desc"));
        for (WebElement webElements : inventoryItemDescription){
            System.out.println(webElements.getText()); //getText() method returns the text of the web element
            System.out.println("===================");
        }
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
