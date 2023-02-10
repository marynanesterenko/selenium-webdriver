package homeworks;

import commons.class04_Feb01_Browser_Navigation.CommonMethods;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
Homework 1
1. In a new homework class open https://magento.softwaretestingboard.com/
2. Command/Control click on the “Sale” option in the header
3. switchTo() the new opened tab (window)
4. Assert that all of the promotion blocks are displayed
5. Close the tab and switch back to the primary tab
6. Assert that you are back on the landing page
 */
public class Homework_Feb7 extends CommonMethods {

    @Test
    public void learnWindowHandlingHW() {

        WebDriver driver = getDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Actions actionsObj = new Actions(driver);

        WebElement saleBtn = driver.findElement(By.xpath("//a[@id='ui-id-8']/span"));

        actionsObj.keyDown(Keys.CONTROL).click(saleBtn).keyUp(Keys.CONTROL).build().perform();

        String primaryWindow = driver.getWindowHandle();

        Set<String> windowsSet = driver.getWindowHandles();
        ArrayList<String> windowsList = new ArrayList<>(windowsSet);

        for (String windowId : windowsList) {
            if (!primaryWindow.equals(windowId)) {
                driver.switchTo().window(windowId);
                if (driver.getCurrentUrl().contains("https://magento.softwaretestingboard.com/sale.html")) {
                    List<WebElement> promotions =
                            driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='block-promo-wrapper block-promo-3columns']/a")));
                    for (WebElement promotionsList : promotions) {
                        Assert.assertTrue("the elements are not present", promotionsList.isDisplayed());
                    }
                } else {
                    driver.close();
                }
            }
        }
        driver.switchTo().window(primaryWindow);
        Assert.assertTrue("you are not on the primary window", saleBtn.isDisplayed());
    }

    @Before
    public void setUp() {
        createDriver("https://magento.softwaretestingboard.com/");
    }

    @After
    public void cleanUp() {
        quitDriver();
    }
}
