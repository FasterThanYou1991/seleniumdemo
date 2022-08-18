package com.selenium.demo.tests;

import com.selenium.demo.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void registerUser() {
        int randomNumber = (int) (Math.random() * 1000);
        String email = "Tester" + randomNumber + "@tester.pl";
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData(email, "tester0@tester.pl")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void registerWithSameEmailTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData("tester1@tester1.pl", "tester1@tester1.pl")
                .getError();

        Assert.assertTrue(error.getText().contains("An account is already registered with your email address. Please log in."));
    }
}
