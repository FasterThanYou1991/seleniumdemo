package com.selenium.demo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class SeleniumHelper {


    public static void waitMethod(String xpath, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    public static void waitForElementToExist(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public static void waitForClickable(WebElement element, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitClickAtPoint(WebDriver driver, String xpath){
        try {
            WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        }catch (Exception e){
            System.out.println("Error from Code: " + Arrays.toString(e.getStackTrace()));
        }
    }

    public static void nameMatchHelper(WebDriver driver, String pathForElements, String elementName, String PathToElementToClick){
        String [] elementNeeded = {elementName};
        // Enter path, which have multiple elements, but we want to select one, or more of them
        List<WebElement> amountOfElements = driver.findElements(By.cssSelector((pathForElements)));
        for(int i = 0; i < amountOfElements.size(); i++)
        {
            String[] name = amountOfElements.get(i).getText().split(" ");
            String formattedName = name[1].trim();
            // We can remove space or other characters using split() and trim() method
            List<String> elementNeededList = Arrays.asList(elementNeeded);
            //Convert array into array list for easy search

            //Check whether element you extracted is present in array or not
            if(elementNeededList.contains(formattedName))
            {
                driver.findElements(By.xpath(String.valueOf(PathToElementToClick))).get(i).click();
                break;
            }
        }
    }

    public static void fluentWaitHelper(WebDriver driver, String path){
       Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
               .withTimeout(Duration.ofSeconds(10))
               .pollingEvery(Duration.ofSeconds(3))
               .ignoring(NoSuchElementException.class);

       WebElement foo = wait.until(new Function<WebDriver, WebElement>(){
           public WebElement apply(WebDriver driver){
               if(driver.findElement(By.xpath(path)).isDisplayed())
               {
                    return driver.findElement(By.xpath(path));
               }
               else
               {
                   return null;
               }
           }
           });
    }
}
