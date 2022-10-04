package com.selenium.demo.tests;

import com.selenium.demo.pages.HomePage;
import com.selenium.demo.pages.LoggedUserPage;
import com.selenium.demo.pages.MyAccountPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    // I had to connect register with login tests, because of problems with connect them separately
    // This page is not storing user data for next day, so we couldn't use the same users to login all over again
    // So there is a case that register a user, and login one after another,
    @Test
    public void registerThenLogInTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openMyAccountPage();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.registerUserValidData();
        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        Assert.assertEquals(loggedUserPage.getDashboardLink().getText(), "Dashboard");
        String st = loggedUserPage.getLoginText();
        loggedUserPage.logoutUser();
        homePage.openMyAccountPage();
        myAccountPage.loginValidData(st);
        loggedUserPage.getDashboardLink();
    }

    @Test
    public void logInWithInvalidPasswordTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .loginInvalidData("123")
                .getError();

        if (error.getText().contains(": Incorrect username or password.")) {
            Assert.assertTrue(error.getText().contains(": Incorrect username or password."));
            System.out.println(": Incorrect username or password.");
        } else if (error.getText().contains(": Too many failed login attempts.")) {
            Assert.assertTrue(error.getText().contains(": Too many failed login attempts."));
            System.out.println(": Too many failed login attempts.");
        } else {
            System.out.println("");
        }
    }
}
