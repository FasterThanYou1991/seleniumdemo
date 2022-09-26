package com.selenium.demo.tests;

import com.selenium.demo.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test(priority = 1)
    public void registerUser() {
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData()
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test(priority = 2)
    public void registerWithSameEmailTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData()
                .getError();

        Assert.assertTrue(error.getText().contains("An account is already registered with your email address. Please log in."));
    }
}
