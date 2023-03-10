package commons.class06_Feb03_Advanced_Mouse_Interactions;

import commons.class05_Feb01_CSS_Locators.CommonMethods;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*
1. In a new Homework class open this page: https://magento.softwaretestingboard.com/
2. Once on the page scroll down to the bottom of the page where the “Hot Sellers” section is visible
3. Select an item and hover over it
4. While hovering assert that the add to cart button is visible then select the size and color
5. Once item is added to cart page should reload
6. After page has been reloaded you can proceed to check out. (Either through the cart icon or the cart page)
7. Once on checkout page fill out the form USE FAKE INFO (Try to challenge yourself and use complex locators)
8. Once you reach Review & Payments assert that the info you entered is the info displayed
9. Then hit place order and assert that your order has been placed by checking the success screen.

Optional Brain Twister Homework
In a new Homework Class open this page: https://phptravels.com/demo/
Fill out and submit the form (You need to solve the expression in order to properly submit the form and the numbers change everytime you load the page)
Once you successfully submit assert that you are on the success screen
This is a pretty big homework with lots of approach1_practice_and_homework if you can't finish all of it at least try as much as you can (At the very least approach1_practice_and_homework the parts you feel weaker on). You should be able to approach1_practice_and_homework topics such as dropdowns, actions class, and a LOT of locator approach1_practice_and_homework. I advise you try to challenge yourself with locators.
Have a great weekend everyone you are all doing very well. Feel free to let me know if you have any questions on the homework or need any clarification!
 */
public class Homework_Feb3 extends CommonMethods {

    @Test
    public void homework() throws InterruptedException{
        WebDriver driver = getDriver();
        Actions action = new Actions(driver);
        WebElement hotSellersBtn = driver.findElement(By.xpath("//h2[@class='title']"));
        action.scrollToElement(hotSellersBtn).build().perform();
        WebElement productName = driver.findElement(By.xpath("//div[@data-product-id='1812']"));
        action.moveToElement(productName).build().perform();
        WebElement addToCartBtn = driver.findElement(By.xpath("//form[@data-product-sku='WT09']//span[text()='Add to Cart']"));
        Assert.assertTrue(addToCartBtn.isDisplayed());

        WebElement sizeBtn = driver.findElement(By.xpath("//div[@class='swatch-opt-1812']//div[@id='option-label-size-143-item-167']"));
        WebElement colorBtn = driver.findElement(By.xpath("//div[@id='option-label-color-93-item-59']"));

        action.click(sizeBtn).click(colorBtn).moveToElement(addToCartBtn).click().build().perform();
        Thread.sleep(4000);

        driver.navigate().refresh();
        Thread.sleep(3000);

        WebElement cartBadge = driver.findElement(By.className("counter-number"));
        WebElement proceedToChkBth = driver.findElement(By.id("top-cart-btn-checkout"));

        action.click(cartBadge).click(proceedToChkBth).build().perform();
        Thread.sleep(4000);

        // checkout form locators


    }

    @Before
    public void setUp(){
        createDriver("https://magento.softwaretestingboard.com/");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
