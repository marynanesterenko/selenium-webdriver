package commons.cookies;

import commons.class05_Feb01_CSS_Locators.CommonMethods;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.Duration;

public class HandlingCookies extends CommonMethods {

    @Test
    public void learnCookieHandling() throws InterruptedException{
        WebDriver driver = getDriver();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //create file named Cookies to store information
        File file = new File("Cookies.data");
        try {
            // we need to make sure that is the old Cookie file exists - we need to delete it
            file.delete();

            // creating a new file
            file.createNewFile();

            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // loop for getting the cookie information
            for (Cookie cookie : driver.manage().getCookies()){
                bufferedWriter.write(cookie.getName() + ";"
                                        + cookie.getValue() + ";"
                                        + cookie.getDomain() + ";"
                                        + cookie.getPath() + ";"
                                        + cookie.getExpiry() + ";"
                                        + cookie.isSecure());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();


        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
