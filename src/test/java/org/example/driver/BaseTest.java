package org.example.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public static WebDriver driver;
    Logger logger= LogManager.getLogger(BaseTest.class);
    private final String URL="https://www.kitapyurdu.com/";
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-translate");

        driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get(URL);
        Assert.assertEquals(URL,driver.getCurrentUrl());
        logger.info(URL+" acildi");
    }
    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
