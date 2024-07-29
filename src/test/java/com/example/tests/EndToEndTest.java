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
public class EndToEndTest extends BaseTest {

    private HomePage homePage;

    private RegisterPage registerPage;
    private LoginPage loginPage;
    private CartPage cartPage;
    private ComputersPage computersPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setup() {
        super.setup();
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        computersPage = new ComputersPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void endToEndTransaction() throws InterruptedException {
        String timestamp = Long.toString(System.currentTimeMillis());
        String emailadd = "john.doe+" + timestamp + "@example.com";

        homePage.clickRegister();
        registerPage.registerUser("John", "Doe", emailadd, "password123");

        ExtentReportManager.addScreenshot(driver, "Registration Screenshot");
        registerPage.logout();
        homePage.clickLogin();
        loginPage.loginUser(emailadd, "password123");
        ExtentReportManager.addScreenshot(driver, "Login Screenshot");

        homePage.clickComputers();
        ExtentReportManager.addScreenshot(driver, "Computers Page");

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

        checkoutPage.checkout();
        ExtentReportManager.addScreenshot(driver, "Checkout");

        checkoutPage.fillCheckoutForm("East ", "236547654", "7784", "00087564");
        ExtentReportManager.addScreenshot(driver, "Fill Checkout Form");

        checkoutPage.completeTransaction();
        ExtentReportManager.addScreenshot(driver, "Complete Checkout");

        ExtentReportManager.addScreenshot(driver, "completed Transaction");
    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}