package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By email = By.id("Email");
    private By password = By.id("Password");
    private By loginButton = By.xpath("//button[contains(text(),'Log in')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loginUser(String email, String pass) {
        driver.findElement(this.email).sendKeys(email);
        driver.findElement(this.password).sendKeys(pass);
        driver.findElement(loginButton).click();
    }


}