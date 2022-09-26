package com.selenium.demo.pages;

import com.selenium.demo.utils.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage extends SeleniumHelper {

    @FindBy(partialLinkText = "Proceed to checkout")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//td[@class='product-name']")
    private WebElement productName;

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public AddressDetailsPage openAddressDetails() {
        waitForClickable(proceedToCheckoutButton,driver);
        proceedToCheckoutButton.click();
        return new AddressDetailsPage(driver);
    }
    public String checkProduct() {
        return productName.getText();
    }
}
