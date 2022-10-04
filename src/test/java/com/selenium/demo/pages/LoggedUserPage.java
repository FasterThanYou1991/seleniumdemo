package com.selenium.demo.pages;

import com.selenium.demo.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserPage extends SeleniumHelper {


    @FindBy(linkText = "Dashboard")
    private WebElement dashboardLink;

    @FindBy(xpath = "//li/a[text()='Logout']")
    private WebElement logout;

    @FindBy(xpath = "//li/a[text()='Orders']")
    private WebElement ordersTab;

    @FindBy(xpath = "(//h1/a)[1]")
    private String seleniumDemoHeader;


    private WebDriver driver;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getDashboardLink() {
        waitForElementToExist(driver, By.linkText("Dashboard"));
        fluentWaitHelper(driver, "(//h1/a)[1]");
        return dashboardLink;
    }
    public String getLoginText(){
        // (//p/strong)[3] -> alternative xpath
        WebElement login = driver.findElement(By.xpath("//div/p/strong[contains(text(),'')]"));
        return login.getText();
    }

    public void logoutUser(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logout);
        logout.click();
    }

    public void orders(){
        // alternative xpath's
        // "//nav/ul/li[1]/following-sibling::li[1]"
        // "//div[@class='woocommerce-MyAccount-content']//p/strong[2]"
        waitMethod("//li/a[text()='Orders']", driver);
        ordersTab.click();
    }
}
