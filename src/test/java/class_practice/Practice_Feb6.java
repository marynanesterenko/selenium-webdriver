package class_practice;

import commons.CommonMethods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Practice_Feb6 extends CommonMethods {

    @Test
    public void fillOutForm () {

        WebDriver driver = getDriver();

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Maryna");

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Nesterenko");

        WebElement gender = driver.findElement(By.xpath("//input[@id='sex-1']"));
        gender.click();

        WebElement yearsOfExp = driver.findElement(By.xpath("//input[@id='exp-6']"));
        yearsOfExp.click();

        WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
        date.sendKeys("06Feb2023");

        WebElement profession = driver.findElement(By.xpath("//input[@id='profession-1']"));
        profession.click();

        WebElement automationTools = driver.findElement(By.xpath("//input[@id='tool-2']"));
        automationTools.click();

        WebElement continents = driver.findElement(By.xpath("//select[@class='input-xlarge']']"));
        continents.sendKeys("North America");

        WebElement fileUploadInput = driver.findElement(By.cssSelector("//input[@id='photo']"));
        fileUploadInput.sendKeys("C:/TEST/TEST.jpg");
    }

    @Before
    public void setUp(){
        createDriver("https://www.techlistic.com/p/selenium-practice-form.html");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }

}
