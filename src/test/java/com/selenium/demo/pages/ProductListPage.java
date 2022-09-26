package com.selenium.demo.pages;

import com.selenium.demo.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductListPage extends SeleniumHelper {

    @FindBy(xpath = "//a[@data-product_id='29']")
    private WebElement AddToCartBDD;

    @FindBy(xpath = "//li[@class='nav__woocart menu-item-has-children czr-dropdown']")
    private WebElement basketIcon;

    @FindBy(xpath = "//a[@title='View cart']")
    private List<WebElement> viewCart;

    private WebDriver driver;

    public ProductListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage openProduct(String title) {
        driver.findElement(By.xpath("//h2[text()='" + title + "']")).click();
        return new ProductPage(driver);
    }
    public void addBddCucumber(){
        waitMethod("//a[@data-product_id='29']", driver);
        AddToCartBDD.click();
    }

    public void clickOnViewCart(){
        waitClickAtPoint(driver, "//a[@title='View cart']");
        viewCart.stream().filter(WebElement::isDisplayed).findFirst().ifPresent(WebElement::click);
    }
    public String getBddCucumberText(){
        waitMethod("//h2[@class='woocommerce-loop-product__title' and text()='BDD Cucumber']", driver);
        WebElement courseName = driver.findElement(By.xpath("//h2[@class='woocommerce-loop-product__title' and text()='BDD Cucumber']"));
        return courseName.getText();
    }
}
