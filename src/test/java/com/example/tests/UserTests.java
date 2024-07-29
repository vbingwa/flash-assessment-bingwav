package com.example.tests;

import com.example.base.BaseTest;
import com.example.pages.ComputersPage;
import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import com.example.pages.RegisterPage;
import com.example.reporting.ExtentReportManager;
import com.example.reporting.TestListener;
import org.junit.Before;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestListener.class)
public class UserTests extends BaseTest {

    @BeforeMethod
    public void setup() {
        super.setup();
    }

    @Test
    public void testUserRegistrationAndLogin() {

        String timestamp = Long.toString(System.currentTimeMillis());
        String emailadd = "john.doe+" + timestamp + "@example.com";

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

        // Add a screenshot after login
        ExtentReportManager.addScreenshot(driver, "Login Screenshot");
    }

    @Test
    public void testNegativeRegistrationWrongEmailFormat()
    {
        HomePage homePage = new HomePage(driver);
        homePage.clickRegister();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.registerUser("John", "Doe", "john.doe@example.", "password123");
        // Add a screenshot after registration
        ExtentReportManager.addScreenshot(driver, "Incorrect Registration Screenshot");
    }

    @Test
    public void testNegativeIncorrectUsernamePassword() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser("john.doe@example.com", "78sword123");

        // Add a screenshot after login
        ExtentReportManager.addScreenshot(driver, "Invalid Login Screenshot");

    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}