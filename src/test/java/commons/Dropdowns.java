package commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdowns extends CommonMethods{

    @Test
    public void learnDropdowns() throws InterruptedException{
        WebDriver driver = getDriver();

        driver.navigate().to("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        Thread.sleep(3000);
        WebElement dropdown = driver.findElement(By.xpath("//select"));

        //Select class has a constructor with parameter WebElement therefore we need to pass an element to the class
        // the element we pass it should be the dropdown we want to manipulate
        Select countriesDropDown = new Select(dropdown);

        // countriesDropdown.getOptions() method returns a List<WebElement> of all the option tags that are children
        List<WebElement> optionsList = countriesDropDown.getOptions();

        // enhanced for loop which will cycle through the list of countries we have in out dropdown
        for (WebElement option : optionsList){
            System.out.println(option.getText());
        }

        System.out.println(countriesDropDown.getOptions());
        System.out.println(dropdown.getText());

        //Select Class has a lot of different methods that do various different things such as selecting a specific
        // options in side of the select tag, returning a specific value, and etc.
        countriesDropDown.selectByVisibleText("Bermuda");
        Thread.sleep(3000);
    }

    @Before
    public void setUp(){
        createDriver("https://www.saucedemo.com/inventory.html");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }
}
