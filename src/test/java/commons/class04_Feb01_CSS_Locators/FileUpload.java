package commons.class04_Feb01_CSS_Locators;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverUtils;

public class FileUpload extends DriverUtils {

    //pre-condition
    @Before
    public void setUp(){
        createDriver("https://demoqa.com/upload-download");
    }

    // this is out test method
    // with this test we can verify the file upload functionality works
    @Test
    public void uploadFile() throws InterruptedException {

        // Step 1: we have to do this, because in DriverUtils Class, the "driver" variable is "private"
        // since we cannot access that variable from here, we have to override "getDriver" method from DriverUtils Class
        // and assign it's return value, which is the new Chromedriver Object, to current Class's "driver" variable
        WebDriver driver = getDriver();

        // Step 2: we have to find the "uploadFile" button on our WebPage
        // and here we are doing it with the help of .findElement() method and cssSelector
        // (fileuploadinput is an instance of the WebElement
        WebElement fileUploadInput = driver.findElement(By.cssSelector("#uploadFile"));

        // Step 3: we have to attach the file after we click the "uploadFile" button on our WebPage
        // and here we are doing it with the help of .sendKeys() method and the location of the file on our computer
        fileUploadInput.sendKeys("C:/Users/Maryna/IdeaProjects/TestFile.txt");

        // Step 4: .sleep() method helps us to wait a few seconds while the file actually gets uploaded
        // and we get the following message as a confirmation: "C:\fakepath\TestFile.txt"
        Thread.sleep(5000);

        // Step 5: we can assert here that that confirmation is displayed below our button upon successful file upload
        // we found that "text" on the WebPage and assigned it into the variable "confirmation"
        WebElement confirmation = driver.findElement(By.id("uploadedFilePath"));
        String actual = confirmation.getText();
        Assert.assertEquals("C:\\fakepath\\TestFile.txt", actual);
        Assert.assertTrue(confirmation.isDisplayed());
    }
    @After
    public void cleanUp(){
        quitDriver();
    }
}
