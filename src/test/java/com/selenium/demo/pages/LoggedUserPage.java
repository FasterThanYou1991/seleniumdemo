package com.selenium.demo.pages;

import com.selenium.demo.utils.SeleniumHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LoggedUserPage extends SeleniumHelper {


    @FindBy(linkText = "Dashboard")
    private WebElement dashboardLinkText;

    @FindBy(xpath = "//li/a[text()='Logout']")
    private WebElement logout;

    @FindBy(xpath = "//li/a[text()='Orders']")
    private WebElement ordersTab;

    @FindBy(xpath = "(//h1/a)[1]")
    private String seleniumDemoHeader;

    @FindBy(css = "nav[class='woocommerce-MyAccount-navigation']")
    private WebElement dashboardLinks;


    private WebDriver driver;

    public LoggedUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getDashboardLink() {
        waitForElementToExist(driver, By.linkText("Dashboard"));
        fluentWaitHelper(driver, "(//h1/a)[1]");
        return dashboardLinkText;
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

    public void getDashboardLinksInNewTab(){
        for(int i = 1; i < dashboardLinks.findElements(By.tagName("a")).size(); i++)
        {
            String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            dashboardLinks.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
        }
        //if there is any new window tab available, we'll switch to it and print the title
        Set<String> tab = driver.getWindowHandles();
        Iterator<String> iterator = tab.iterator();
        while(iterator.hasNext())
        {
            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());
        }
        System.out.println("Dashboard links amount: " + dashboardLinks.findElements(By.tagName("a")).size());
    }
}
