package com.selenium.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {

    @FindBy(xpath = "//p[text()='Thank you. Your order has been received.']")
    private WebElement orderNotice;

    @FindBy(xpath = "//a[@href='http://seleniumdemo.com/?product=produkt-testowy-1' and text()='Java Selenium WebDriver']")
    private WebElement productName;

    private WebDriver driver;
    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public WebElement getOrderNotice() {
        return orderNotice;
    }

    public WebElement getProductName() {
        return productName;
    }
}
