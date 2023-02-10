package commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

/**
 * Questions:
 * How do we handle dropdown web element in Selenium?
 * We use the Select interface:
 * 1. When we create an instance of this interface to work with it
 * 2. We can use a List and put all of the options in that List by using the .getOptions() method.
 * 3. We can then manipulate the elements in the List created by using the same methods that we use for WebElements
      as the List created will be a List of WebElements (List<WebElement>)
 * 4. We can select different options in the dropdown by various different methods.
 * 5. We can select an item by the visible text, value, and the index of the item
 * 6. We have a bunch of deselecting options such as deselecting by index, deselecting by value, deselecting by text, etc
 */
public class class05_Feb3rd_DropdownHandling extends CommonMethods{

    @Test
    public void learnDropdowns() throws InterruptedException{
        WebDriver driver = getDriver();

        driver.navigate().to("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
        Thread.sleep(3000);

        WebElement dropdown = driver.findElement(By.xpath("//select"));
        WebElement selectCountryTitle = driver.findElement(By.id("Select Country"));

        // to duplicate the line use Ctrl+D. !NOTE: your cursor has to be at the end of the line as you are doing the Ctrl+D
        System.out.println(selectCountryTitle.getAttribute("id"));
        System.out.println(selectCountryTitle.getAttribute("class"));
        System.out.println(selectCountryTitle.getAttribute("aria-controls"));
        System.out.println(selectCountryTitle.getAttribute("role"));

        System.out.println("-----------------------");

        // Select Class has a Constructor with parameter WebElement, therefore we need to pass an element to the Class
        // the element we pass, should be the dropdown we want to manipulate
        Select countriesDropDown = new Select(dropdown);

        // countriesDropdown.getOptions() method returns a List<WebElement> of all the option tags that are children
        //to the current select tag
        List<WebElement> optionsList = countriesDropDown.getOptions();

        // using this syntax, we can retrieve the name of the dropdown option under a particular index
        optionsList.get(0).getText();

        // Cycling through a list of options created on line 38 and printing the text stored inside the tag and the
        // attribute "value"
        for (WebElement option : optionsList){
            System.out.println(option.getText() + "\t" + option.getAttribute("value"));
        }
        System.out.println(countriesDropDown.getOptions());
        System.out.println(dropdown.getText());

        //Select Class has a lot of different methods that do various different things such as selecting a specific
        //options in side of the select tag, returning a specific value, and etc.
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
