package commons.class04_Feb01_CSS_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverUtils;

public abstract class CommonMethods extends DriverUtils {

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
