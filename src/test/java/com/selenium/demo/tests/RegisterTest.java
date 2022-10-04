package com.selenium.demo.tests;

import com.selenium.demo.pages.HomePage;
import com.selenium.demo.pages.LoggedUserPage;
import com.selenium.demo.pages.MyAccountPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test(priority = 1)
    public void registerUser() {
        HomePage homePage = new HomePage(driver);
        homePage.openMyAccountPage();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.registerUserValidData();
        LoggedUserPage loggedUserPage = new LoggedUserPage(driver);
        Assert.assertEquals(loggedUserPage.getDashboardLink().getText(), "Dashboard");
    }

    @Test
    public void registerWithSameEmailTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData()
                .getError();
        Assert.assertTrue(error.getText().contains("An account is already registered with your email address. Please log in."));
    }

}
