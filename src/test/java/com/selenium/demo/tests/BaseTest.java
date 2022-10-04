package com.selenium.demo.tests;

import com.selenium.demo.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://seleniumdemo.com/");
    }

    //@AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
