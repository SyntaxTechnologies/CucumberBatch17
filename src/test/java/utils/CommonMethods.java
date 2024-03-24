package utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods extends PageInitializer {

    public static WebDriver driver;

    public void openBrowserAndLaunchApplication(){

        switch (ConfigReader.read("browser")){
            case "Chrome":
                ChromeOptions options=new ChromeOptions();
                options.setHeadless(true);
                driver = new ChromeDriver(options);
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("invalid browser name");
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.read("url"));
        initializePageObjects();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
    }

    public void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }


    public WebDriverWait getWait(){
        WebDriverWait wait = new WebDriverWait(driver,
                Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;
    }

    public void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    public JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    public void closeBrowser(){
        driver.quit();
    }

    //take screenshot method for capturing all the screenshots
    public byte[] takeScreenshot(String fileName){
        TakesScreenshot ts = (TakesScreenshot) driver;
        //in cucumber screenshot should be taken in array of byte format
        //since the size of the image is in byte, that's why the return type of this
        //method is array of byte
        byte[] picByte = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        //we will pass the path of ss from constants class
        try {
            FileUtils.copyFile
                    (sourceFile, new File
                            (Constants.SCREENSHOT_FILEPATH +
                                    fileName+" "+
                                    getTimeStamp("yyyy-MM-dd-HH-mm-ss")
                                    +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picByte;
    }

    //in java we have a module which returns current date and time
    public String getTimeStamp(String pattern){
        Date date = new Date();
        //after getting the date, I need to format it as per my requirement
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        //it willl return the formatted date as per the pattern in string format
        return sdf.format(date);
    }
}
