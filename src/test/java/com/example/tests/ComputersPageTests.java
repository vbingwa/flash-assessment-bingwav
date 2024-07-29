package com.example.tests;

import com.example.base.BaseTest;
import com.example.pages.ComputersPage;
import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import com.example.pages.RegisterPage;
import com.example.reporting.ExtentReportManager;
import com.example.reporting.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ComputersPageTests extends BaseTest {

    @BeforeMethod
    public void setup() {
        super.setup();
    }

    @Test
    public void testClickDesktops() {
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

        ExtentReportManager.addScreenshot(driver, "Login Screenshot");
        homePage.clickComputers();

        ExtentReportManager.addScreenshot(driver, "Computers");
        ComputersPage computersPage = new ComputersPage(driver);
        computersPage.clickDesktops();

        ExtentReportManager.addScreenshot(driver, "Desktops");
        // Add assertions or further actions here
    }

    @Test
    public void testSelectSortOption() {
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
        homePage.clickComputers();
        ComputersPage computersPage = new ComputersPage(driver);
        computersPage.clickDesktops();
        computersPage.selectSortOption("Name: A to Z");
        computersPage.selectSortOption("Name: Z to A");
        computersPage.selectSortOption("Price: Low to High");
        computersPage.selectSortOption("Price: High to Low");
        computersPage.selectSortOption("Created on");

    }

    @AfterMethod
    public void tearDown() {
        super.tearDown();
    }
}