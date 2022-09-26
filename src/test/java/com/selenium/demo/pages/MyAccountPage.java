package com.selenium.demo.pages;

import com.selenium.demo.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends SeleniumHelper {

    @FindBy(id = "reg_email")
    private WebElement regEmailInput;

    @FindBy(id = "reg_password")
    private WebElement regPasswordInput;

    @FindBy(xpath = "//button[@type='submit' and text()='Register']")
    private WebElement registerButton;

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement error;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    private WebDriver driver;
    private final String emailAccount = randomEmail();
    private final String passwordAccount = randomPassword();

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LoggedUserPage registerUserValidData() {
        waitForElementToExist(driver, By.id("reg_email"));
        registerUser();
        return new LoggedUserPage(driver);
    }

    public MyAccountPage registerUserInvalidData() {
        registerUser();
        return this;
    }

    private void registerUser() {
        waitForElementToExist(driver, By.id("reg_email"));
        regEmailInput.click();
        regEmailInput.sendKeys(emailAccount);
        regPasswordInput.click();
        regPasswordInput.sendKeys(passwordAccount);
        registerButton.click();
    }

    public WebElement getError() {
        return error;
    }

    public LoggedUserPage loginValidData(String username, String password) {
        logIn(username, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage loginInvalidData(String username, String password) {
        logIn(username, password);
        return this;
    }

    private void logIn(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public String randomEmail(){
        int randomNumber = (int) (Math.random() * 1000);
        return "Tester" + randomNumber + "@tester.pl";
    }

    public String randomPassword(){
        int randomNumber = (int) (Math.random() * 1000);
        return "Tester" + randomNumber + "@tester";
    }
}
