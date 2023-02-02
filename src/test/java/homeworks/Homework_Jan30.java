package homeworks;

/*
1. Create a homework package
2. Create a Homework1 class in that package
3. Follow the steps we used in the DayTwo class to open saucedemo.com and login.
4. Once on the product page add the first item to the cart
   (Note. The add to cart buttons have IDs, so you should be able to use those).
5. After the item has been added to cart open the cart page by clicking on the cart link at the top right
6. Verify that the item you added to cart .isDisplayed() in the cart page
 */

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverUtils;

public class Homework_Jan30 extends DriverUtils {

    @Test
    public void login() throws InterruptedException{
        WebDriver driver = getDriver();

        // Login Page
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();
        Thread.sleep(3000);

        // Product Catalog Page
        WebElement tshirtAddToCartBtn = driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"));
        tshirtAddToCartBtn.click();
        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();

        WebElement addedTshirt = driver.findElement(By.className("inventory_item_name"));
        Assert.assertTrue("Test.allTheThings() T-Shirt (Red) has not been added to the cart", addedTshirt.isDisplayed());

    }

    @Before
    public void setUp(){
        createDriver("https://www.saucedemo.com/");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }


}
