package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By registerLink = By.linkText("Register");
    private By loginLink = By.linkText("Log in");
    private By computersTab = By.linkText("Computers");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRegister() {
        driver.findElement(registerLink).click();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }

    public void clickComputers() {
        driver.findElement(computersTab).click();
    }
}