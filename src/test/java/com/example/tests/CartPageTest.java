package com.example.tests;


import com.example.base.BaseTest;
import com.example.pages.*;
import com.example.reporting.ExtentReportManager;
import com.example.reporting.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)


public class CartPageTest extends BaseTest {


    @BeforeMethod
    public void setup() {
        super.setup();


    }

    @Test
    public void testAddDesktopToCart() throws InterruptedException {
        String timestamp = Long.toString(System.currentTimeMillis());
        String emailadd = "john.doe+" + timestamp + "@example.com";
        CartPage cartPage = new CartPage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser("John", "Doe", emailadd, "password123");

        // Add a screenshot after registration
        ExtentReportManager.addScreenshot(driver, "Registration Screenshot");
        registerPage.logout();
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(emailadd, "password123");

        ExtentReportManager.addScreenshot(driver, "Login Screenshot");
        homePage.clickComputers();
        ExtentReportManager.addScreenshot(driver, "Computers");
        ComputersPage computersPage = new ComputersPage(driver);
        computersPage.clickDesktops();
        ExtentReportManager.addScreenshot(driver, "Desktops");

        cartPage.addDesktopToCart();
        ExtentReportManager.addScreenshot(driver, "Add To Cart");

        String totalPrice = cartPage.getTotalPrice();

        ExtentReportManager.addScreenshot(driver, "Get Total Price");

        System.out.println("Total Price " + totalPrice);

        ExtentReportManager.getTest().info("Total Price " + totalPrice);

        cartPage.removeItemFromCart();

        ExtentReportManager.addScreenshot(driver, "Remove From Cart");

        String updatedTotalPrice = cartPage.getTotalPrice();
        ExtentReportManager.addScreenshot(driver, "Get Updated Total Price");

        System.out.println("Total Price " + updatedTotalPrice);

        ExtentReportManager.getTest().info("Total Price " + updatedTotalPrice);

        // Add assertions or further actions here
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }

}
