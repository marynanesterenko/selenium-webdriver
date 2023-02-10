package homeworks;

import commons.class04_Feb01_Browser_Navigation.CommonMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
This is a pretty big homework with lots of practice if you can't finish all of it at least try as much as you can (At the very least practice the parts you feel weaker on). You should be able to practice topics such as dropdowns, actions class, and a LOT of locator practice. I advise you try to challenge yourself with locators.
Have a great weekend everyone you are all doing very well. Feel free to let me know if you have any questions on the homework or need any clarification!
 */
public class Homework_Feb3 extends CommonMethods {

    @Test
    public void homework() {
        WebDriver driver = getDriver();

        WebElement hotSellersBtn = driver.findElement(By.xpath("//h2[@class='title']"));


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
