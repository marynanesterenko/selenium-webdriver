package commons;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUpload extends DayOne{

    @Before
    public void setUp(){
        createDriver("https://demoqa.com/upload-download");
    }

    @After
    public void cleanUp(){
        quitDriver();
    }

    @Test
    public void learnFileUpload() {
        WebDriver driver = getDriver();
        WebElement fileUploadInput = driver.findElement(By.cssSelector("#uploadFile"));
        fileUploadInput.sendKeys("/Users/yegorbannov/Desktop/TestFile.txt");

    }






}
