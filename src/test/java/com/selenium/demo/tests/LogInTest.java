package com.selenium.demo.tests;

import com.selenium.demo.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {

    @Test
    public void logInTest() {

        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .loginValidData("tester1@tester1.pl", "tester0@tester.pl")
                .getDashboardLink();

        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void logInWithInvalidPasswordTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .loginInvalidData("tester1@tester1.pl", "123")
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
