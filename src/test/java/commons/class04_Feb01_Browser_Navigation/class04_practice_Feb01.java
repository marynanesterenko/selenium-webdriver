package commons.class04_Feb01_Browser_Navigation;

import commons.class04_Feb01_Browser_Navigation.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
1. Open sauce demo and log in
2. Assert that the shopping cart button is visible and then click the shopping cart button
3. Assert that the checkout button is visible
4. Then go back to the products page add an item to cart
5. Then back to cart page and assert that the item is there
 */
public class class04_practice_Feb01 extends CommonMethods {

    @Test
    public void practice1() throws InterruptedException {
        WebDriver driver = getDriver();

        // logging in to the website
        loginToSauceDemo();
        Thread.sleep(3000);

        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        Assert.assertTrue("shopping cart button is not visible", cartButton.isDisplayed());
        cartButton.click();

        WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout"));
        Assert.assertTrue("shopping cart button is not visible", checkoutButton.isDisplayed());
        driver.navigate().back();

        WebElement addItemToCart = driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"));
        addItemToCart.click();
        driver.navigate().forward();

        WebElement verifyTheItemGotAdded = driver.findElement(By.className("inventory_item_name"));
        Assert.assertTrue("the item did not get added to the cart", verifyTheItemGotAdded.isDisplayed());
        System.out.println(verifyTheItemGotAdded.getText());
    }


    @Before
    public void setUp(){
        createDriver("http://saucedemo.com/");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
