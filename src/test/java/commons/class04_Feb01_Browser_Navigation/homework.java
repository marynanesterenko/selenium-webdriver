package commons.class04_Feb01_Browser_Navigation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.DriverUtils;
/*

1. Open and login to saucedemo.com
2. Then click on the filter and select Price (low to high) (See image attached below)
3. Assert that the span with active-option class value has changed to the option you selected
4. Now refresh the page and ensure that the filter changed back to its original state

OPTIONAL advanced task:
5. Before refreshing the page ensure that the first item is indeed the cheapest one.
 */
public class homework extends DriverUtils {

    @Test
    public void verifyFilter() throws InterruptedException{

        WebDriver driver = getDriver();
        loginToSauceDemo();

        WebElement filterButton = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        filterButton.click();

        Thread.sleep(2000);

        WebElement dropdown = driver.findElement(By.xpath("//select"));

        Select dropdownOptions = new Select(dropdown);
        dropdownOptions.selectByVisibleText("Price (low to high)");

        WebElement filterValue = driver.findElement(By.xpath("//span[@class='active_option']"));
        Assert.assertTrue("The value in filter has not changed", filterValue.getText().contains("PRICE (LOW TO"));




        driver.navigate().refresh();
        WebElement filterValueAfterRefresh = driver.findElement(By.xpath("//span[@class='active_option']"));
        Assert.assertTrue("The value in filter has not changed", filterValueAfterRefresh.getText().contains("NAME (A TO Z)"));
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
