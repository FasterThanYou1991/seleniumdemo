package com.selenium.demo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;

public class SeleniumHelper {

    public static void waitMethod(String xpath, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    public static void waitForElementToExist(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10l);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public static void waitForClickable(WebElement element, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10L);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitClickAtPoint(WebDriver driver, String xpath){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        }catch (Exception e){
            System.out.println("Error from Code: " + Arrays.toString(e.getStackTrace()));
        }
    }
}
