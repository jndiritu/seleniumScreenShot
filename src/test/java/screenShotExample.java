/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author mutts
 */
public class screenShotExample {

    public WebDriver driver;
    public WebDriverWait wait;

    public screenShotExample() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("Setting up the chrome driver...");
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        System.out.println("Initializing the browser...");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        System.out.println("Setting the browser to full screen...");
        driver.manage().window().fullscreen();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        //Close and quit the web driver
        driver.close();
        driver.quit();
    }

    @Test
    public void screenShotExample() throws IOException, InterruptedException {
        //get and load the link, in our case twitter
        driver.get("https://twitter.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log in")));
        //Take Screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //Copy the screenshot to folder of your choice. In this case the project root folder
        FileUtils.copyFile(src, new File("twitterLaunchLoginPage.png"));
        Thread.sleep(3000);
    }
}
