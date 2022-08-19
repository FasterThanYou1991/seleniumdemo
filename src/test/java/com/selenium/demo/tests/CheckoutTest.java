package com.selenium.demo.tests;

import com.selenium.demo.models.Customer;
import com.selenium.demo.pages.HomePage;
import com.selenium.demo.pages.OrderDetailsPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {

        Customer customer = new Customer();
        // We can override hardcoded default values set in Customer class
        customer.setPhone("345678908");
        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer, "Some comment");

        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText(),"Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getProductName().getText(),"Java Selenium WebDriver");
    }
}
